package com.free.freeassignment.rate.task;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.free.freeassignment.rate.bean.RateEntity;

@Component
public class FetchRate {
	public FetchRate() {
		super();
	}

	public static RateEntity eur_to_sek_rate = new RateEntity("EUR", "SEK", new BigDecimal("11.43727"));
	public static RateEntity eur_to_usd_rate = new RateEntity("EUR", "USD", new BigDecimal("1.084552"));
	public static RateEntity sek_to_eur_rate = new RateEntity("SEK", "EUR", new BigDecimal("0.087671"));
	public static RateEntity sek_to_usd_rate = new RateEntity("SEK", "USD", new BigDecimal("0.095789"));
	public static RateEntity usd_to_eur_rate = new RateEntity("USD", "EUR", new BigDecimal("0.915261"));
	public static RateEntity usd_to_sek_rate = new RateEntity("USD", "SEK", new BigDecimal("10.54912"));

	public void setRates() {
		eur_to_sek_rate.updateRate();
		eur_to_usd_rate.updateRate();
		sek_to_eur_rate.updateRate();
		sek_to_usd_rate.updateRate();
		usd_to_eur_rate.updateRate();
		usd_to_sek_rate.updateRate();
	}

	public BigDecimal getRate(String from, String to) {
		BigDecimal rate = null;

		if (from.equals("EUR")) {
			if (to.equals("SEK")) {
				rate = eur_to_sek_rate.getRate();
			} else if (to.equals("USD")) {
				rate = eur_to_usd_rate.getRate();
				System.out.println(rate);
			}
		} else if (from.equals("USD")) {
			if (to.equals("SEK")) {
				rate = usd_to_sek_rate.getRate();
			} else if (to.equals("EUR")) {
				rate = usd_to_eur_rate.getRate();
			}
		} else if (from.equals("SEK")) {
			if (to.equals("USD")) {
				rate = sek_to_usd_rate.getRate();
			} else if (to.equals("EUR")) {
				rate = sek_to_eur_rate.getRate();
			}
		}

		return rate;
	}

	@Scheduled(cron = "0 0 */1 * * ?")
	public void everyOneHour() {
		System.out.println("Periodic task: " + new Date());
		setRates();
	}

}
