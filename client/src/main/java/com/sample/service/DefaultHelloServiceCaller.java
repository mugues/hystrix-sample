package com.sample.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DefaultHelloServiceCaller implements HelloServiceCaller{
    private static final Logger logger = LoggerFactory.getLogger(DefaultHelloServiceCaller.class);

    private static int timeout = 1000;

    private static RestTemplate restTemplate = getRestTemplate();

    @Override
    @HystrixCommand(fallbackMethod = "reliableCallHelloService", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20")
    })
    public String callHelloService() {
        String helloServiceUrl = "http://localhost:9090/hello-service";

        String helloServiceResponse = restTemplate.getForObject(helloServiceUrl, String.class);

        return helloServiceResponse;
    }


    public static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
        factory.setReadTimeout(timeout);
        factory.setConnectTimeout(timeout);
        return restTemplate;
    }

    public String reliableCallHelloService() {
        return "reliableCallHelloService";
    }
}
