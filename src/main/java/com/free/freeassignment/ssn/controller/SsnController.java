package com.free.freeassignment.ssn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.free.freeassignment.exception.ApiError;
import com.free.freeassignment.ssn.bean.Ssn;
import com.free.freeassignment.ssn.bean.SsnResponse;
import com.free.freeassignment.ssn.exception.CountryCodeNotFoundException;

@RestController
public class SsnController {
	@PostMapping("/validate_ssn")
	public SsnResponse validate(@RequestBody Ssn newSSn) {
		boolean ssn_valid;
		newSSn.validateCountryCode();

		ssn_valid = newSSn.validateSsn();

		SsnResponse response = new SsnResponse(ssn_valid);

		return response;
	}

	@ExceptionHandler(value = CountryCodeNotFoundException.class)
	public ResponseEntity<ApiError> handleCountryCodeNotFoundException(
			CountryCodeNotFoundException countryCodeNotFoundException) {
		ApiError apierror = new ApiError(HttpStatus.NOT_FOUND, countryCodeNotFoundException.getMessage());
		return new ResponseEntity<ApiError>(apierror, apierror.getStatus());
	}
}
