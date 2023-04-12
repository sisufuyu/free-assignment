package com.free.freeassignment.ssn.bean;

public class SsnResponse {
	private boolean ssn_valid;

	public SsnResponse(boolean ssn_valid) {
		super();
		this.ssn_valid = ssn_valid;
	}

	public boolean isSsn_valid() {
		return ssn_valid;
	}

	public void setSsn_valid(boolean ssn_valid) {
		this.ssn_valid = ssn_valid;
	}

}
