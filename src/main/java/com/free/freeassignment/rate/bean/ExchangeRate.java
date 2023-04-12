package com.free.freeassignment.rate.bean;

import java.math.BigDecimal;

import com.free.freeassignment.rate.exception.CurrencyNotFoundException;
import com.free.freeassignment.rate.task.FetchRate;

public class ExchangeRate {
	private String from;
	private String to;
	private BigDecimal from_amount;
	private BigDecimal exchange_rate;
	private ExchangeTo exchange_to = new ExchangeTo();
	private FetchRate fetch = new FetchRate();

	public ExchangeRate(String from, String to, BigDecimal from_amount) {
		super();
		this.from = from;
		this.to = to;
		this.from_amount = from_amount;
	}

	public ExchangeTo exchange() throws CurrencyNotFoundException {
		exchange_rate = fetch.getRate(this.from, this.to);

		if(exchange_rate == null) {
			throw new CurrencyNotFoundException("Currency not found, only supports EUR & SEK & USD now");
		}

		BigDecimal to_amount = exchange_rate.multiply(from_amount);

		exchange_to.setFrom(from);
		exchange_to.setTo(to);
		exchange_to.setExchange_rate(exchange_rate);
		exchange_to.setTo_amount(to_amount);

		return exchange_to;
	}

	@Override
	public String toString() {
		return "ExchangeRate [from=" + from + ", to=" + to + ", from_amount=" + from_amount + ", exchange_rate="
				+ exchange_rate + "]";
	}

}
