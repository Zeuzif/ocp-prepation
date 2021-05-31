package me.wassif.exceptions;

import java.io.IOException;

public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7211034928198441003L;

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(Exception exception) {
		super(exception);
	}

	public static void main(String[] args) throws CustomException {
		try {
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

abstract class Human {
	abstract public void eat() throws CustomException;

	abstract public void run() throws Exception;
}

class Person extends Human {
	// not throw at all
	@Override
	public void eat() {
	}

	// throw a more specific
	@Override
	public void run() throws CustomException {
	}
}
