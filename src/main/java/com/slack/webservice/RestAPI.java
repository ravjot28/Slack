package com.slack.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.rav.audtioapp.action.SlackRequestDTO;
import com.slack.helper.SlackHelper;

@Path("/slackAPI")
public class RestAPI {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getChannelDetails")
	public String sendRequestToSlack(SlackRequestDTO request) {
		return new SlackHelper().sendRequest(request.getChannelId());
	}

	@GET
	@Path("/getSlackChannels")
	public String sendRequestToSlack() {
		return new SlackHelper().sendRequest();
	}

}
