package com.slack.action;

import java.io.IOException;
import java.net.MalformedURLException;

import com.slack.helper.Util;

public class GetSlackChannelsAction {
	private String jsonString;

	public String execute() {
		try {
			jsonString = Util.webServiceCall("http://localhost:8080/slackBackend/slackAPI/getSlackChannels");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

}
