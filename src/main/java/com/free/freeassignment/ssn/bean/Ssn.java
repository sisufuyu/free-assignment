package com.free.freeassignment.ssn.bean;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.free.freeassignment.ssn.exception.CountryCodeNotFoundException;

public class Ssn {
	private String ssn;
	private String country_code;

	public Ssn(String ssn, String country_code) {
		super();
		this.ssn = ssn;
		this.country_code = country_code;
	}

	public boolean validateSsn() {
		int length = this.ssn.length();
		if (length != 11) {
			return false;
		}

		String day = this.ssn.substring(0, 2);
		String month = this.ssn.substring(2, 4);
		String year = this.ssn.substring(4, 6);

		LocalDate birthday;

		char sign = this.ssn.charAt(6);

		if (sign == '-') {
			year = "19" + year;
		} else if (sign == '+') {
			year = "18" + year;
		} else if (sign == 'A') {
			year = "20" + year;
		} else {
			return false;
		}

		String date = year + "-" + month + "-" + day;

		LocalDate now = LocalDate.now();

		try {
			birthday = LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			return false;
		}

		if (birthday.isAfter(now)) {
			return false;
		}

		String individualString = this.ssn.substring(7, 10);

		int individualNumber = Integer.parseInt(individualString);

		if (individualNumber < 2 || individualNumber > 899) {
			return false;
		}

		int digits = Integer.parseInt(this.ssn.substring(0, 6) + individualString);

		int remainder = digits % 31;

		List<String> controlChars = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
				"F", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "U", "V", "W", "X", "Y");

		String controlChar = controlChars.get(remainder);


		if (!controlChar.equals(this.ssn.substring(10, 11))) {
			return false;
		}

		return true;
	}

	public void validateCountryCode() throws CountryCodeNotFoundException {
		if (!country_code.equals("FI")) {
			throw new CountryCodeNotFoundException("Only supports country code FI now");
		}
	}

	@Override
	public String toString() {
		return "Ssn [ssn=" + ssn + ", country_code=" + country_code + "]";
	}

}
