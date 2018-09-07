# Web crawler

## Task

Web Crawler

Please write a simple web crawler. The crawler should be limited to one domain. Given a starting URL – say http://www.domain.com/  - it should visit all pages within the domain, but not follow the links to external sites such as Google or Twitter.

The output should be a simple structured site map (this does not need to be a traditional XML sitemap - just some sort of output to reflect what your crawler has discovered), showing links to other pages under the same domain, links to external URLs and links to static content such as images for each respective page.

Please provide a README.md file that explains how to run / build your solution. Also, detail anything further that you would like to achieve with more time.

Once done, please make your solution available on Github and forward the link. Where possible please include your commit history to give visibility of your thinking and progress.

## Description
This project is using **crawler4j** internally to crawl pages.

Main tradeoffs:

- crawler4j requires temp directory to store data. 


## Setup
    git  clone https://github.com/royjoydeep11/crawler-web-repo.git
    cd crawler-web-repo/
    mvn clean install   -   mvn package
    

## Usage

Run:

     java -jar  target/crawler-web-0.0.1-SNAPSHOT.jar  

Mandatory parameter:

    -u,--url <arg>           website url
    
Optional parameters:

    -c,--crawlers <arg>      number of crawlers (1 by default)
    -d,--delay <arg>         delay in ms (200 by default)
    -m,--max-pages <arg>     max pages to fetch
    -o,--output-file <arg>   output file by default sitemap.xml
    -t,--temp-dir <arg>      temporary directory
    
    
Example:

    java -jar  target/crawler-web-0.0.1-SNAPSHOT.jar --url "https://www.domain.com/"


## Example output XML file format

	```  xml
	<?xml version="1.0" encoding="UTF-8" standalone="no"?>
	<response>
		<pageLinks>
			<url>https://www.domain.com/</url>
			<url>https://www.domain.com/about/</url>
			<url>https://www.domain.com/about/follow</url>
			<url>https://www.domain.com/about/press/</url>
			<url>https://www.domain.com/about/registrar-info</url>
			<url>https://www.domain.com/about/sitemap</url>
			<url>https://www.domain.com/about/testimonials</url>
			<url>https://www.domain.com/about/video</url>
			<url>https://www.domain.com/blog/</url>
			<url>https://www.domain.com/blog/2015/11/10/domain-privacy-what-you-need-to-know/
			</url>
			<url>https://www.domain.com/blog/2018/04/30/gdpr-what-you-need-to-know-and-how-domain-com-helps-you-comply/
			</url>
			<url>https://www.domain.com/blog/2018/07/09/will-googles-latest-update-affect-your-website-and-business/
			</url>
			<url>https://www.domain.com/blog/2018/08/21/major-league-hacking-and-domain/
			</url>
			<url>https://www.domain.com/blog/2018/08/30/after-buying-domain-name/
			</url>
			<url>https://www.domain.com/blog/2018/08/30/choose-the-right-domain-name/
			</url>
			<url>https://www.domain.com/blog/2018/08/30/difference-between-domain-and-a-website/
			</url>
			<url>https://www.domain.com/blog/2018/08/30/when-your-domain-is-taken/
			</url>
			<url>https://www.domain.com/blog/about/</url>
	```

## Example console log output

	java -jar target/crawler-web-0.0.1-SNAPSHOT.jar --url="https://www.domain.com/"
	Sep 06, 2018 9:18:53 AM edu.uci.ics.crawler4j.url.TLDList <init>
	INFO: Obtained 6791 TLD from packaged file tld-names.txt
	Sep 06, 2018 9:18:54 AM edu.uci.ics.crawler4j.crawler.CrawlController <init>
	INFO: Deleted contents of: tmp\frontier ( as you have configured resumable crawling to false )
	Sep 06, 2018 9:18:57 AM edu.uci.ics.crawler4j.crawler.CrawlController start
	INFO: Crawler 1 started
	Sep 06, 2018 9:19:01 AM com.test.crawler.WebCrawlerSpider visit
	INFO: visiting: https://www.domain.com/****domain *************https://www.domain.com/
	Sep 06, 2018 9:19:03 AM com.test.crawler.WebCrawlerSpider visit
	INFO: visiting: https://www.domain.com/hosting/app-vault****domain *************https://www.domain.com/
	Sep 06, 2018 9:19:07 AM com.test.crawler.WebCrawlerSpider visit
	INFO: visiting: https://www.domain.com/about/sitemap****domain *************https://www.domain.com/
	Sep 06, 2018 9:19:09 AM com.test.crawler.WebCrawlerSpider visit
	INFO: visiting: https://www.domain.com/domains/tlds/website****domain *************https://www.domain.com/
	Sep 06, 2018 9:19:11 AM com.test.crawler.WebCrawlerSpider visit
	INFO: visiting: https://www.domain.com/domains/tlds/online****domain *************https://www.domain.com/
	Sep 06, 2018 9:19:13 AM com.test.crawler.WebCrawlerSpider visit
	INFO: visiting: https://www.domain.com/domains/tlds/space****domain *************https://www.domain.com/
	Sep 06, 2018 9:19:17 AM com.test.crawler.WebCrawlerSpider visit
	INFO: visiting: https://www.domain.com/domains/tlds/org****domain *************https://www.domain.com/
	Sep 06, 2018 9:19:19 AM com.test.crawler.WebCrawlerSpider visit
	INFO: visiting: https://www.domain.com/hosting/vps/****domain *************https://www.domain.com/
	Sep 06, 2018 9:19:23 AM com.test.crawler.WebCrawlerSpider visit
	--------------------------------------------------------------------------------------------------------------------------------------
	--------------------------------------------------------------------------------------------------------------------------------------
	Sep 06, 2018 9:26:57 AM edu.uci.ics.crawler4j.crawler.CrawlController$1 run
	INFO: Waiting for 10 seconds before final clean up...
	Sep 06, 2018 9:27:08 AM com.test.crawler.WebCrawlerInvoker saveXMLDocument
	INFO: document saved to: sitemap.xml
	
## Example successfull Maven Build

	[INFO] Building jar: C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\crawler-web-0.0.1-SNAPSHOT-javadoc.jar
	[INFO]
	[INFO] --- maven-install-plugin:2.4:install (default-install) @ crawler-web ---
	[INFO] Installing C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\crawler-web-0.0.1-SNAPSHOT.jar to C:\Users\IBM_ADMIN\.m2\repository\crawler-web\crawler-web\0.0.1-SNAPSHOT\crawler-web-0.0.1-SNAPSHOT.jar
	[INFO] Installing C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\pom.xml to C:\Users\IBM_ADMIN\.m2\repository\crawler-web\crawler-web\0.0.1-SNAPSHOT\crawler-web-0.0.1-SNAPSHOT.pom
	[INFO] Installing C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\crawler-web-0.0.1-SNAPSHOT-sources.jar to C:\Users\IBM_ADMIN\.m2\repository\crawler-web\crawler-web\0.0.1-SNAPSHOT\crawler-web-0.0.1-SNAPSHOT-sources.jar
	[INFO] Installing C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\crawler-web-0.0.1-SNAPSHOT-javadoc.jar to C:\Users\IBM_ADMIN\.m2\repository\crawler-web\crawler-web\0.0.1-SNAPSHOT\crawler-web-0.0.1-SNAPSHOT-javadoc.jar
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 01:08 min
	[INFO] Finished at: 2018-09-06T09:35:32-07:00
	[INFO] Final Memory: 35M/444M
	[INFO] ------------------------------------------------------------------------

## Example successfull Maven Test Case execution

	-------------------------------------------------------
	 T E S T S
	-------------------------------------------------------
	Running com.test.crawler.AppTest
	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.133 sec
	Running com.test.crawler.WebCrawlerTest
	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
	
	Results :
	
	Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
	
	
	Loading source files for package com.test.crawler...
	Constructing Javadoc information...
	Standard Doclet version 1.8.0_101
	Building tree for all the packages and classes...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\App.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\ResponseTransformerToXML.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\WebCrawler.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\WebCrawlerInvoker.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\WebCrawlerResponse.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\WebCrawlerSampleClass.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\WebCrawlerSpider.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\package-frame.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\package-summary.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\package-tree.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\constant-values.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\class-use\WebCrawlerSpider.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\class-use\WebCrawlerSampleClass.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\class-use\WebCrawlerResponse.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\class-use\WebCrawlerInvoker.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\class-use\WebCrawler.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\class-use\ResponseTransformerToXML.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\class-use\App.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\com\test\crawler\package-use.html...
	Building index for all the packages and classes...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\overview-tree.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\index-all.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\deprecated-list.html...
	Building index for all classes...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\allclasses-frame.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\allclasses-noframe.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\index.html...
	Generating C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\apidocs\help-doc.html...
	[INFO] Building jar: C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\crawler-web-0.0.1-SNAPSHOT-javadoc.jar
	[INFO]
	[INFO] --- maven-install-plugin:2.4:install (default-install) @ crawler-web ---
	[INFO] Installing C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\crawler-web-0.0.1-SNAPSHOT.jar to C:\Users\IBM_ADMIN\.m2\repository\crawler-web\crawler-web\0.0.1-SNAPSHOT\crawler-web-0.0.1-SNAPSHOT.jar
	[INFO] Installing C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\pom.xml to C:\Users\IBM_ADMIN\.m2\repository\crawler-web\crawler-web\0.0.1-SNAPSHOT\crawler-web-0.0.1-SNAPSHOT.pom
	[INFO] Installing C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\crawler-web-0.0.1-SNAPSHOT-sources.jar to C:\Users\IBM_ADMIN\.m2\repository\crawler-web\crawler-web\0.0.1-SNAPSHOT\crawler-web-0.0.1-SNAPSHOT-sources.jar
	[INFO] Installing C:\Joydeep-SPACE\Development\Workspaces\STS-Workspace1\crawler-web\target\crawler-web-0.0.1-SNAPSHOT-javadoc.jar to C:\Users\IBM_ADMIN\.m2\repository\crawler-web\crawler-web\0.0.1-SNAPSHOT\crawler-web-0.0.1-SNAPSHOT-javadoc.jar
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 01:08 min
	[INFO] Finished at: 2018-09-06T09:35:32-07:00
	[INFO] Final Memory: 35M/444M
	[INFO] ------------------------------------------------------------------------
	






	
  