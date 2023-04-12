package com.free.freeassignment.rate.bean;

import java.io.IOException;
import java.math.BigDecimal;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RateEntity {
	private String from;
	private String to;
	private BigDecimal rate;

	private Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
	private String apikey = dotenv.get("APIKEY");

	public RateEntity() {
		super();
	}

	public RateEntity(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public RateEntity(String from, String to, BigDecimal rate) {
		super();
		this.from = from;
		this.to = to;
		this.rate = rate;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public void getApikey() {
		System.out.println("apikey " + apikey);
	}

	public void updateRate() {
		OkHttpClient client = new OkHttpClient();

		String url = "https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=1";

		Request request = new Request.Builder().url(url).addHeader("apikey", apikey)
				.build();

		Call call = client.newCall(request);

		call.enqueue(new Callback() {
			@Override
			public void onFailure(@NotNull Call call, @NotNull IOException e) {
				e.printStackTrace();
			}

			@Override
			public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
				if (response.isSuccessful()) {
					String responseBody = response.body().string();

					JSONObject jsonObject = new JSONObject(responseBody);

					String result = jsonObject.optString("result");

					System.out.println("update rate from: " + from + ", to: " + to + ", result: " + result);

					setRate(new BigDecimal(result));
				}
			}
		});
	}
}
