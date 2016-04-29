package com.slack.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Util {
	@SuppressWarnings("deprecation")
	public static String webServiceCall(String url, String channelId) throws MalformedURLException, IOException {
		String result = "";
		try {

			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(url);

			StringEntity input = new StringEntity("{\"channelId\":\"" + channelId + "\"}");
			input.setContentType("application/json");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			System.out.println("Output from Server .... \n");
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				result += output;
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static String webServiceCall(String url) throws MalformedURLException, IOException {
		String result = "";
		try {

			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet postRequest = new HttpGet(url);

			HttpResponse response = httpClient.execute(postRequest);

			// if (response.getStatusLine().getStatusCode() != 201) {
			// throw new RuntimeException("Failed : HTTP error code : " +
			// response.getStatusLine().getStatusCode());
			// }

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			System.out.println("Output from Server .... \n");
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				result += output;
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return result;
	}

}
