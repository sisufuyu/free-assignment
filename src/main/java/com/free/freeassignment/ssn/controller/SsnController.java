package com.free.freeassignment.ssn.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.free.freeassignment.ssn.bean.Ssn;

@RestController
public class SsnController {
	@PostMapping("/validate_ssn")
	public boolean validate(@RequestBody Ssn newSSn) {
		boolean ssn_valid;
		ssn_valid = newSSn.validateCountryCode();

		if (ssn_valid == false) {
			return ssn_valid;
		}

		ssn_valid = newSSn.validateSsn();

		return ssn_valid;
	}
}
