/**
 * 
 */
package com.diycomputerscience.resourcelist.model;

import java.util.List;


/**
 * @author pshah
 *
 */
public class Resource {
	
	private String title;
	private String url;
	private String comments;
	private List<Topic> topics;
	private ResourceType type;
	
	public Resource(String title,
					String url,
					String comments,
					List<Topic> topics,
					ResourceType type) {
		this.title = title;
		this.url = url;
		this.comments = comments;
		this.topics = topics;
		this.type = type;		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}
	
}
