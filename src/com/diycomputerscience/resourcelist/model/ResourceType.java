/**
 * 
 */
package com.diycomputerscience.resourcelist.model;

/**
 * @author pshah
 *
 */
public class ResourceType {
	
	private long id;
	private String name;
	private String description;
	
	public ResourceType(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
