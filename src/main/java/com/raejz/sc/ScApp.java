package com.raejz.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.raejz.sc")
public class ScApp {

  public static void main(String[] args) {
    SpringApplication.run(ScApp.class, args);
  }
}
