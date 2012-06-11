/**
 * 
 */
package com.diycomputerscience.resourcelist.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pshah
 *
 */
public class Urls {
	
	private static String urls[][] = {
		{"^/$", "com.diycomputerscience.resourcelist.view.ShowTopicsView"},
		{"^/topic/(?<slug>[\\w*\\-]*)/?$", "com.diycomputerscience.resourcelist.view.ShowTopicView", "slug"}
	};
	
	public static ViewInfo parse(String pathInfo) throws UrlMatchNotFound {
		for(String url[] : urls) {
			Pattern pattern = Pattern.compile(url[0]);
			Matcher matcher = pattern.matcher(pathInfo);
			if(matcher.matches()) {
				String view = url[1];
				Map<String, String> params = new HashMap<String, String>();
				if(url.length > 2) {
					for(int i=2; i<url.length;i++) {
						String groupName = url[i];
						String value = matcher.group(groupName);
						params.put(groupName, value);
					}
				}				
				return new ViewInfo(view, params);
			}
		}
		//TODO: Throw Exception
		String msg = "Not found '" + pathInfo + "'";
		throw new UrlMatchNotFound(msg);
	}
	
}
