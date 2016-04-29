package com.slack.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackHelper {

	private final String USER_AGENT = "Mozilla/5.0";

	public String sendRequest() {
		String url = "https://slack.com/api/channels.list?token=xoxp-11252443716-12808644501-38344877905-d4bbe93400";
		StringBuffer response = null;
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			int count = 0;
			while ((inputLine = in.readLine()) != null) {
				count++;
				response.append(inputLine);
			}
			in.close();
			System.out.println(count);
		} catch (Exception e) {

		}

		return response.toString();
	}

	public String sendRequest(String data) {
		String url = "https://slack.com/api/channels.history?token=xoxp-11252443716-12808644501-38344877905-d4bbe93400&channel="
				+ data;
		StringBuffer response = null;
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			int count = 0;
			while ((inputLine = in.readLine()) != null) {
				count++;
				response.append(inputLine);
			}
			in.close();
			System.out.println(count);
		} catch (Exception e) {

		}

		return response.toString();
	}

}
