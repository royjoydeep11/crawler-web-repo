package com.test.crawler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WebCrawlerTest extends TestCase{

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WebCrawlerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WebCrawlerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
