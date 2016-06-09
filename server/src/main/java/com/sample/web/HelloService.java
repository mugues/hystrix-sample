package com.sample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {
	private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

	private static int counter =0;
	
	@RequestMapping(value = "/hello-service", method = RequestMethod.GET)
    String sayHello() {
		counter++;
		logger.debug("hello-service being called {}", counter);

		return "Hello service";
    }

}
