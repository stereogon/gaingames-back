package com.fitnessapp.exception;

public class WorkoutNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public WorkoutNotFoundException() {
		super();
	}

	public WorkoutNotFoundException(String message) {
		super(message);
	}

	public WorkoutNotFoundException(Throwable cause) {
		super(cause);
	}
}
