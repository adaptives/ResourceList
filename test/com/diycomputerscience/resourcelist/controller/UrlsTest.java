/**
 * 
 */
package com.diycomputerscience.resourcelist.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author pshah
 *
 */
public class UrlsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPathInfoForHome() throws Exception {
		ViewInfo viewInfo = Urls.parse("/");
		assertNotNull(viewInfo);
		assertEquals("com.diycomputerscience.resourcelist.view.ShowTopicsView", viewInfo.viewName);
		assertEquals(0, viewInfo.params.keySet().size());
	}
	
	@Test
	public void testPathInfoForTopic() throws Exception {
		ViewInfo viewInfo = Urls.parse("/topic/core-java");
		assertNotNull(viewInfo);
		assertEquals("com.diycomputerscience.resourcelist.view.ShowTopicView", viewInfo.viewName);
		assertEquals("core-java", viewInfo.params.get("slug"));
	}
	
	@Test
	public void testPathInfoForTopicWithTrailingSlash() throws Exception {
		ViewInfo viewInfo = Urls.parse("/topic/java/");
		assertNotNull(viewInfo);
		assertEquals("com.diycomputerscience.resourcelist.view.ShowTopicView", viewInfo.viewName);
		assertEquals("java", viewInfo.params.get("slug"));
	}
	
	@Test(expected=UrlMatchNotFound.class)
	public void testPathInfoForUrlMatchNotFound() throws Exception {
		ViewInfo viewInfo = Urls.parse("/category/java/");		
	}

}
