package com.test.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class WebCrawler {

    private Integer maxPages = 500;

    private Integer crawlers = 1;

    private String tempDir;

    private Integer delay = 200;

    private WebCrawlerResponse response;

    public WebCrawler(String tempDir) {

        this.tempDir = tempDir;
        this.response = new WebCrawlerResponse();
    }

    public WebCrawlerResponse crawl(String url) throws Exception {

        WebCrawlerSpider.configure(response, url);
        CrawlController controller = getCrawlController();
        controller.addSeed(url);
        controller.start(WebCrawlerSpider.class, crawlers);

        return response;

    }

    private CrawlController getCrawlController() throws Exception {

        CrawlConfig config = new CrawlConfig();
        config.setPolitenessDelay(delay);
        config.setCrawlStorageFolder(tempDir);
        config.setMaxPagesToFetch(maxPages);
        config.setFollowRedirects(true);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        return controller;
    }

    public void setMaxPages(Integer maxPages) {
        this.maxPages = maxPages;
    }

    public void setCrawlers(Integer crawlers) {
        this.crawlers = crawlers;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}
