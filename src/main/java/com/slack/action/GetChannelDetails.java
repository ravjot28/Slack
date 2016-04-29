package com.slack.action;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rav.audtioapp.action.SlackRequestDTO;
import com.slack.helper.Util;

public class GetChannelDetails {
	private String jsonString;
	List<String> array = new ArrayList<String>();

	public List<String> getArray() {
		return array;
	}

	public void setArray(List<String> array) {
		this.array = array;
	}

	public String execute() {
		SlackRequestDTO dto = getDTO(array.get(0));

		try {
			jsonString = Util.webServiceCall("http://localhost:8080/slackBackend/slackAPI/getChannelDetails", dto.getChannelId());
			System.out.println("Value of jsonString " + jsonString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	private SlackRequestDTO getDTO(String data) {
		SlackRequestDTO dto = new SlackRequestDTO();

		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setChannelId(getValue(obj, "channelId"));
		return dto;
	}

	private String getValue(JSONObject obj, String key) {
		String value = null;
		try {
			value = (String) obj.get(key);
		} catch (Exception e) {

		}
		return value;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

}
