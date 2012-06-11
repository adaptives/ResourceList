/**
 * 
 */
package com.diycomputerscience.resourcelist.model;

/**
 * @author pshah
 *
 */
public class Topic {
	private long id;
	private String title;
	private String slug;
	private String description;
	
	public Topic(String title,
				 String slug,
				 String description) {
		this.title = title;
		this.slug = slug;
		this.description = description;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
