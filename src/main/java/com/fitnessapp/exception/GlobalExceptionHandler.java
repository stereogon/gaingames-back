package com.fitnessapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fitnessapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String message = "REQUEST METHOD NOT SUPPORTED";
		String error = "ERROR OCCURRED: STRING ERROR";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, httpStatus, LocalDateTime.now(), error);
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String message = "MEDIA TYPE NOT SUPPORTED";
		String error = "ERROR OCCURRED: STRING ERROR";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, httpStatus, LocalDateTime.now(), error);
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String message = "MISSING SERVLET REQUEST PARAMETER";
		String error = "ERROR OCCURRED: STRING ERROR";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, httpStatus, LocalDateTime.now(), error);
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String message = "TYPE MISMATCH";
		String error = "ERROR OCCURRED: STRING ERROR";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, httpStatus, LocalDateTime.now(), error);
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}

	@ExceptionHandler(TrainerNotFoundException.class)
	public ResponseEntity<Object> handleTrainerNotFound(TrainerNotFoundException e) {
		String message = e.getMessage();
		String error = "trainer not found";
		ApiErrors apiError = new ApiErrors(message, HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(), error);

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(apiError);
	}

	@ExceptionHandler(WorkoutNotFoundException.class)
	public ResponseEntity<Object> handleWorkoutNotFound(WorkoutNotFoundException e) {
		String message = e.getMessage();
		String error = "workout not found";
		ApiErrors apiError = new ApiErrors(message, HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(), error);

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(apiError);
	}
}
