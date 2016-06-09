package com.sample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.service.HelloServiceCaller;

@RestController
public class HelloClient {
	private static final Logger logger = LoggerFactory.getLogger(HelloClient.class);

	@Autowired
	private HelloServiceCaller helloServiceCaller;
	
	@RequestMapping(value = "/hello-client", method = RequestMethod.GET)
    String callHelloService() {
		String helloServiceResponse = helloServiceCaller.callHelloService();

		logger.debug("response {}",helloServiceResponse);

		return helloServiceResponse;
	}

}
