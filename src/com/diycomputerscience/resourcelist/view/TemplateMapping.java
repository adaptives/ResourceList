/**
 * 
 */
package com.diycomputerscience.resourcelist.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pshah
 *
 */
public class TemplateMapping {
	
	private Map<String, String> mapping;
	
	public TemplateMapping() {
		this.mapping = new HashMap<String, String>();
		mapping.put("home", "home.jsp");
		mapping.put("topics", "topics.jsp");
		mapping.put("topic", "topic.jsp");
	}
	
	public void render(String templateId, 
					   HttpServletRequest request, 
					   HttpServletResponse response) throws ServletException, IOException {
		
		String templateName = this.mapping.get(templateId);
		String destination = "/" + templateName;		
		request.getRequestDispatcher(destination).forward(request, response);
	}
}
