/**
 * 
 */
package com.diycomputerscience.resourcelist.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diycomputerscience.resourcelist.model.IDataFacade;

/**
 * @author pshah
 *
 */
public abstract class View {

	public abstract String show(HttpServletRequest request, 
					 		    HttpServletResponse response,
					 		    Map<String, String> params,
					 		    IDataFacade dataFacade) throws ViewException;
	
}
