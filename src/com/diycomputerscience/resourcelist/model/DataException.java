/**
 * 
 */
package com.diycomputerscience.resourcelist.model;

/**
 * @author pshah
 *
 */
public class DataException extends Exception {

	public DataException() {
		super();
	}
	
	public DataException(String msg) {
		super(msg);
	}
	
	public DataException(Throwable cause) {
		super(cause);
	}
	
	public DataException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
