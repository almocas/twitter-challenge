package com.twitter.rest.exception;

/**
 * @author almocas
 *
 */
public class NotFoundException extends RuntimeException{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3625211027667556119L;

	public NotFoundException(String message) {
		super(message);
	}

}
