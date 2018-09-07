package com.test.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.regex.Pattern;

public class WebCrawlerSpider extends WebCrawler {

    static final Logger logger = LoggerFactory.getLogger(WebCrawlerSpider.class);

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|zip|gz|xml))$");

    private final static String LINK_SELECTOR = "body a[href]";

    private final static String IMAGE_SELECTOR = "body img";

    private static WebCrawlerResponse response;

    private static String domain;

    private static String host;

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
         return !FILTERS.matcher(href).matches() && href.startsWith(WebCrawlerSpider.domain) ;
        /*return !FILTERS.matcher(href).matches()
                && href.contains("www.prudential.co.uk")
                && href.contains("ports");*/
    }

    @Override
    public void visit(Page page) {

        if (!(page.getParseData() instanceof HtmlParseData)) {
            return;
        }

        String url = normalizeUrl(page.getWebURL().getURL(), domain);

        logger.info("visiting: " + url+"****domain *************"+domain);
        response.addPageLink(url);

        HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
        String html = htmlParseData.getHtml();

        Document doc = Jsoup.parse(html);
        doc.setBaseUri(url);

        String link;
        Elements elements;

        elements = doc.select(LINK_SELECTOR);
        for (Element element : elements) {
            link = normalizeUrl(element.attr("href"), domain);
            if (isExternalLink(link) && link.length() > 0) {
                response.addExternalLink(link);
            }
        }

        elements = doc.select(IMAGE_SELECTOR);
        for (Element element : elements) {
            link = normalizeUrl(element.attr("src"), domain);
            if (link.length() > 0) {
                response.addMediaLink(link);
            }
        }

    }

    private String normalizeUrl(String link, String domain) {

        if(link.startsWith("mailto:")) {
            return "";
        }

        URI uri;
        try {

            uri = new URI(link);
            if (!uri.isAbsolute()) {
                uri = new URI(domain + "/")
                        .resolve(uri)
                        .normalize();
            }

            String uriStr = uri.toString();

            // remove fragment
            if(uri.getFragment() != null) {
                int index = uriStr.indexOf("#");
                if (index == -1) { // should't occur
                    return uriStr;
                }
                return uriStr.substring(0, index);
            }

            return uriStr;

        } catch (URISyntaxException e) {}

        return "";
    }

    private boolean isExternalLink(String link) {

        if (link.equals("")) {
            return false;
        }

        URI uri;

        try {
            uri = new URI(link);
            if(Objects.equals(uri.getHost(), WebCrawlerSpider.host)) {
                return false;
            }
            return true;

        } catch (URISyntaxException e) {}

        return false;
    }

    public static void configure(WebCrawlerResponse response, String url) throws URISyntaxException {

        WebCrawlerSpider.response = response;

        WebCrawlerSpider.domain = url;
        WebCrawlerSpider.host = new URI(WebCrawlerSpider.domain).getHost();
    }
}
