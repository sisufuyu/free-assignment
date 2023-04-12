package com.free.freeassignment.rate.bean;

import java.math.BigDecimal;

public class ExchangeTo {
	private String from;
	private String to;
	private BigDecimal to_amount;
	private BigDecimal exchange_rate;

	public ExchangeTo() {
		super();
	}

	public ExchangeTo(String from, String to, BigDecimal to_amount, BigDecimal exchange_rate) {
		super();
		this.from = from;
		this.to = to;
		this.to_amount = to_amount;
		this.exchange_rate = exchange_rate;
	}

	@Override
	public String toString() {
		return "ExchangeTo [from=" + from + ", to=" + to + ", to_amount=" + to_amount + ", exchange_rate="
				+ exchange_rate + "]";
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getTo_amount() {
		return to_amount;
	}

	public BigDecimal getExchange_rate() {
		return exchange_rate;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setTo_amount(BigDecimal to_amount) {
		this.to_amount = to_amount;
	}

	public void setExchange_rate(BigDecimal exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

}
