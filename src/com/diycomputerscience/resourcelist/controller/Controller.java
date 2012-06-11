package com.diycomputerscience.resourcelist.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diycomputerscience.resourcelist.model.IDataFacade;
import com.diycomputerscience.resourcelist.model.JDBCDataFacadeImpl;
import com.diycomputerscience.resourcelist.view.TemplateMapping;
import com.diycomputerscience.resourcelist.view.View;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IDataFacade dataFacade;
    private TemplateMapping mapping;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	this.dataFacade = new JDBCDataFacadeImpl();
    	this.mapping = new TemplateMapping();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
								 throws ServletException, IOException {
		doPost(request, response);			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) 
								  	throws ServletException, IOException {
		// Note: Remember do not put too much logic in classes 
		// which require infrastructure support		
		try {			
			ViewInfo viewInfo = Urls.parse(request.getPathInfo());
			View view = (View)Class.forName(viewInfo.viewName).newInstance();
			String templateId = view.show(request, response, viewInfo.params, dataFacade);
			this.mapping.render(templateId, request, response);
		} catch(Exception e) {
			//log the error
			throw new ServletException("Internal Server Error");
		}
	}

}
