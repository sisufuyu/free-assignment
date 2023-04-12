package com.free.freeassignment.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;

	private ApiError() {
		timestamp = LocalDateTime.now();
	}

	public ApiError(HttpStatus status) {
		this();
		this.setStatus(status);
		this.message = "Unexpected error";
	}

	public ApiError(HttpStatus status, String message) {
		this();
		this.setStatus(status);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
