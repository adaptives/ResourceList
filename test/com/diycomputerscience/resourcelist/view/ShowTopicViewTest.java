/**
 * 
 */
package com.diycomputerscience.resourcelist.view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.diycomputerscience.resourcelist.model.DataException;
import com.diycomputerscience.resourcelist.model.IDataFacade;
import com.diycomputerscience.resourcelist.model.Resource;
import com.diycomputerscience.resourcelist.model.ResourceType;
import com.diycomputerscience.resourcelist.model.Topic;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.expectLastCall;


/**
 * @author pshah
 *
 */
public class ShowTopicViewTest {

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
	public void testShowSuccess() throws Exception {
		String slug = "java";
		Topic topic = new Topic("Java", "java", "Java Description");
		topic.setId(1L);
		//create a resource type model object to be used in instantiating a Resource
		ResourceType resourceTypeBlogPost = new ResourceType("blog", "Blog Post");
		//create a List to hold multiple resources... returned by the mock data facade
		List<Resource> resources = new ArrayList<Resource>();
		//create the topics our resources will be associated with
		List<Topic> topicsForResources = new ArrayList<Topic>();
		topicsForResources.add(topic);
		//create resources
		Resource javaBlog1 = new Resource("Java generics", "http://blogs.java.com/bloch/generics.html", "no comments", topicsForResources, resourceTypeBlogPost);
		Resource javaBlog2 = new Resource("Java annotations", "http://blogs.java.com/bloch/annotations.html", "no comments", topicsForResources, resourceTypeBlogPost);
		//add resources to the list
		resources.add(javaBlog1);
		resources.add(javaBlog2);
		
		//create mocks
		HttpServletRequest mockRequest = createMock(HttpServletRequest.class);
		HttpServletResponse mockResponse = createMock(HttpServletResponse.class);
		Map<String, String> mockParams = new HashMap<String, String>();		
		mockParams.put("slug", slug);
		IDataFacade mockDataFacade = createMock(IDataFacade.class);
		
		//set expectations
		expect(mockDataFacade.fetchTopicBySlug(slug)).andReturn(topic);
		expect(mockDataFacade.fetchAllResourcesByTopic(topic.getId())).andReturn(resources);
		mockRequest.setAttribute("topic", topic);
		mockRequest.setAttribute("resources", resources);		
		
		//replay
		replay(mockRequest, mockResponse, mockDataFacade);
		
		//invoke actual method
		ShowTopicView view = new ShowTopicView();
		String logicalFwd = view.show(mockRequest, mockResponse, mockParams, mockDataFacade);
		assertEquals("topic", logicalFwd);
		//verify
		verify(mockRequest, mockDataFacade);	
	}
	
	@Test(expected=ViewException.class)
	public void testShowWithDataException() throws Exception {
		String slug = "java";
		Topic topic = new Topic("Java", "java", "Java Description");
		topic.setId(1L);
		//create a resource type model object to be used in instantiating a Resource
		ResourceType resourceTypeBlogPost = new ResourceType("blog", "Blog Post");
		//create a List to hold multiple resources... returned by the mock data facade
		List<Resource> resources = new ArrayList<Resource>();
		//create the topics our resources will be associated with
		List<Topic> topicsForResources = new ArrayList<Topic>();
		topicsForResources.add(topic);
		//create resources
		Resource javaBlog1 = new Resource("Java generics", "http://blogs.java.com/bloch/generics.html", "no comments", topicsForResources, resourceTypeBlogPost);
		Resource javaBlog2 = new Resource("Java annotations", "http://blogs.java.com/bloch/annotations.html", "no comments", topicsForResources, resourceTypeBlogPost);
		//add resources to the list
		resources.add(javaBlog1);
		resources.add(javaBlog2);
		
		//create mocks
		HttpServletRequest mockRequest = createMock(HttpServletRequest.class);
		HttpServletResponse mockResponse = createMock(HttpServletResponse.class);
		Map<String, String> mockParams = new HashMap<String, String>();		
		mockParams.put("slug", slug);
		IDataFacade mockDataFacade = createMock(IDataFacade.class);
		
		//set expectations
		expect(mockDataFacade.fetchTopicBySlug(slug)).andThrow(new DataException("Could not fetch data"));
		
		//replay
		replay(mockRequest, mockResponse, mockDataFacade);
		
		//invoke actual method
		ShowTopicView view = new ShowTopicView();
		view.show(mockRequest, mockResponse, mockParams, mockDataFacade);		
	}

}
