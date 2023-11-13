package com.developer.pramod.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.developer.pramod.model.SMSSendRequest;
import com.developer.pramod.service.SMSService;

@RestController
public class SMSController {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SMSController.class);
	
	@Autowired
	private SMSService smsService;
	
	@PostMapping("/processSMS")
	public String processSMS(@RequestBody SMSSendRequest sendRequest) {
		logger.info("processSMS started sendRequest" + sendRequest.toString());
		return smsService.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getSmsMessage());
	}

}
