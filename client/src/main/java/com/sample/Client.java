package com.sample;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@ImportResource({
    "classpath*:/application-context/common-context.xml",
})
public class Client
{

  public static void main(String[] args) throws Exception
  {
    SpringApplication.run(Client.class, args);
  }

  @Bean
  public HystrixCommandAspect hystrixAspect() {
    return new HystrixCommandAspect();
  }

}
