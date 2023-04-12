package com.free.freeassignment.rate.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.free.freeassignment.exception.ApiError;
import com.free.freeassignment.rate.bean.ExchangeRate;
import com.free.freeassignment.rate.bean.ExchangeTo;
import com.free.freeassignment.rate.exception.CurrencyNotFoundException;
import com.free.freeassignment.rate.exception.FetchRateException;

@RestController
public class RateController {
	@GetMapping("/exchange_amount")
	public ExchangeTo exchange_amount(@RequestParam String from, @RequestParam String to,
			@RequestParam(name = "from_amount") String amount) throws Exception {
		ExchangeRate exchange_rate = new ExchangeRate(from, to, new BigDecimal(amount));

		return exchange_rate.exchange();
	}

	@ExceptionHandler(value = CurrencyNotFoundException.class)
	public ResponseEntity<ApiError> handleCurrencyNotFoundException(
			CurrencyNotFoundException currencyNotFoundException) {
		ApiError apierror = new ApiError(HttpStatus.NOT_FOUND, currencyNotFoundException.getMessage());
		return new ResponseEntity<ApiError>(apierror, apierror.getStatus());
	}

	@ExceptionHandler(value = FetchRateException.class)
	public ResponseEntity<ApiError> handleFetchRateException(FetchRateException fetchRateException) {
		ApiError apierror = new ApiError(HttpStatus.BAD_REQUEST, fetchRateException.getMessage());
		return new ResponseEntity<ApiError>(apierror, apierror.getStatus());
	}
}
