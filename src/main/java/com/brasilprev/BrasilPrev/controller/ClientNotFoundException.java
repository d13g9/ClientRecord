package com.brasilprev.BrasilPrev.controller;

public class ClientNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ClientNotFoundException(Long id) {
	    super("Could not find employee " + id);
	  }
}
