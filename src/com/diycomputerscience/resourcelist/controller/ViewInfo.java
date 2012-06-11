/**
 * 
 */
package com.diycomputerscience.resourcelist.controller;

import java.util.Map;

/**
 * @author pshah
 *
 */
public class ViewInfo {
	
	public final String viewName;
	public final Map<String, String> params;
	
	public ViewInfo(String viewName, Map<String, String> params) {
		this.viewName = viewName;
		this.params = params;
	}
}
