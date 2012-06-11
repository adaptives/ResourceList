/**
 * 
 */
package com.diycomputerscience.resourcelist.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diycomputerscience.resourcelist.model.IDataFacade;
import com.diycomputerscience.resourcelist.model.Resource;
import com.diycomputerscience.resourcelist.model.Topic;

/**
 * @author pshah
 *
 */
public class ShowTopicView extends View {

	/* (non-Javadoc)
	 * @see com.diycomputerscience.resourcelist.view.View#show(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.util.Map, com.diycomputerscience.resourcelist.model.IDataFacade)
	 */
	@Override
	public String show(HttpServletRequest request,
					   HttpServletResponse response, 
					   Map<String, String> params,
					   IDataFacade dataFacade) throws ViewException {
		try {
			String slug = params.get("slug");			
			Topic topic = dataFacade.fetchTopicBySlug(slug);
			List<Resource> resources = dataFacade.fetchAllResourcesByTopic(topic.getId());
			request.setAttribute("topic", topic);
			request.setAttribute("resources", resources);
			return "topic";
		} catch(Exception e) {
			String msg = "Could not process view";
			throw new ViewException(msg, e);
		}		
	}

}
