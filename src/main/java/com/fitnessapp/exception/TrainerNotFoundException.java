package com.fitnessapp.exception;

public class TrainerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TrainerNotFoundException() {
		super();
	}

	public TrainerNotFoundException(String message) {
		super(message);
	}

	public TrainerNotFoundException(Throwable cause) {
		super(cause);
	}
}
