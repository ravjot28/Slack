<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
.modal {
	display: none;
	position: fixed;
	z-index: 1000;
	top: 0;
	left: 0;
	height: 100%;
	width: 100%;
	background: rgba(255, 255, 255, .8)
		url('http://i.stack.imgur.com/FhHRx.gif') 50% 50% no-repeat;
}

/* When the body has the loading class, we turn
   the scrollbar off with overflow:hidden */
body.loading {
	overflow: hidden;
}

/* Anytime the body has the loading class, our
   modal element will be visible */
body.loading .modal {
	display: block;
}
</style>


<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$body = $("body");

						$(document).on({
							ajaxStart : function() {
								$body.addClass("loading");
							},
							ajaxStop : function() {
								$body.removeClass("loading");
							}
						});

						$
								.get(
										"app/getSlackChannels.action",
										function(data) {
											var response = JSON.parse(data);

											for (i = 0; i < response.channels.length; i++) {
												var $something = $('<input/>')
														.attr(
																{
																	class : "btn-click-action",
																	type : 'button',
																	name : response.channels[i].id,
																	value : response.channels[i].name
																});
												$("#response").append(
														$something);
											}

											$(".btn-click-action")
													.click(
															function() {
																
																		
																			
																$('#chat').val('');
																var channelId = this.name;

																var request = {
																	"channelId" : channelId
																};
																var ajaxData = {};
																ajaxData["array"] = [ JSON
																		.stringify(
																				request)
																		.replace(
																				',',
																				', ')
																		.replace(
																				'[',
																				'')
																		.replace(
																				']',
																				'') ];
																$
																		.ajax({
																			"dataType" : 'json',
																			"type" : "POST",
																			"url" : 'app/getChannelDetails.action',
																			"data" : JSON
																					.stringify(ajaxData),
																			contentType : "application/json; charset=utf-8",
																			async : false,
																			success : function(
																					jsonString) {

																				var response = JSON
																						.parse(jsonString);

																				for (i = 0; i < response.messages.length; i++) {

																					var $chat = $('#chat');
																					$chat
																							.val($chat
																									.val()
																									+ '\n From:'
																									+ response.messages[i].user
																									+ ':'
																									+ response.messages[i].text);

																				}
																				 

																			},
																			complete : function(
																					msg,
																					a,
																					b) {
																				console
																						.log('complete :'
																								+ msg);
																				
																						
																						
																								
																			},
																			error : function(
																					msg,
																					a,
																					b) {
																				console
																						.log('error:'
																								+ msg);
																			}
																		});

															});
										});

					});
</script>


<title>Slack</title>

</head>
<body>

	<div class="container-fullwidth">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Slack</a>
				</div>
				</nav>
			</div>
		</div>
	</div>


	<div id="response"></div>
	<div id="modal-body" class="modal-body">
		<textarea id="chat" class="form-control col-xs-12" rows="7"></textarea>
	</div>
	<div class="modal">
		<!-- Place at bottom of page -->
	</div>

</body>
</html>
