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
import com.diycomputerscience.resourcelist.model.Topic;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.expectLastCall;

public class ShowTopicsViewTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowSuccess() throws Exception {
		HttpServletRequest mockRequest = createMock(HttpServletRequest.class);
		HttpServletResponse mockResponse = createMock(HttpServletResponse.class);
		IDataFacade mockDataFacade = createMock(IDataFacade.class);
		Map<String, String> params = new HashMap<String, String>();		
		
		//set expectations in the mock objects
		List<Topic> topics = new ArrayList<Topic>();
		expect(mockDataFacade.fetchAllTopics()).andReturn(topics);
		mockRequest.setAttribute("topics", topics);
		replay(mockRequest, mockResponse, mockDataFacade);
		
		ShowTopicsView view = new ShowTopicsView();
		view.show(mockRequest, mockResponse, params, mockDataFacade);
		
		verify(mockRequest, mockResponse, mockDataFacade);
		
	}
	
	@Test(expected=ViewException.class)
	public void testShowWithDataError() throws Exception {
		HttpServletRequest mockRequest = createMock(HttpServletRequest.class);
		HttpServletResponse mockResponse = createMock(HttpServletResponse.class);
		IDataFacade mockDataFacade = createMock(IDataFacade.class);
		Map<String, String> params = new HashMap<String, String>();		
		
		//ensure that our mock throws an Exception
		//Note: Understand why we cannot use expect().andThrow()
		expect(mockDataFacade.fetchAllTopics()).andThrow(new DataException("data not found"));
		//Note This is the biggest problem with easymock... it is easy to forget to call replay
		replay(mockDataFacade); 
		
		ShowTopicsView view = new ShowTopicsView();
		view.show(mockRequest, mockResponse, params, mockDataFacade);
		
	}

}
