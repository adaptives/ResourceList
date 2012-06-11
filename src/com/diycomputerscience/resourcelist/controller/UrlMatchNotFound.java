/**
 * 
 */
package com.diycomputerscience.resourcelist.controller;

/**
 * @author pshah
 *
 */
public class UrlMatchNotFound extends Exception {
	
	public UrlMatchNotFound() {
		super();
	}
	
	public UrlMatchNotFound(String msg) {
		super(msg);
	}
	
	public UrlMatchNotFound(Throwable cause) {
		super(cause);
	}
	
	public UrlMatchNotFound(String msg, Throwable cause) {
		super(msg, cause);
	}
}
