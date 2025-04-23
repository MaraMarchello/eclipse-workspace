package org.example.utilities.tascaS302Ex1.exception;

public class PizzaBuilderException extends RuntimeException {

	public PizzaBuilderException(String message) {
		super(message);
	}

	public PizzaBuilderException(String message, Throwable cause) {
		super(message, cause);
	}
}