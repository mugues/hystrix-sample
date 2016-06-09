package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@ImportResource({
    "classpath*:/application-context/common-context.xml",
})
public class Server
{

  public static void main(String[] args) throws Exception
  {
    SpringApplication.run(Server.class, args);
  }

}
