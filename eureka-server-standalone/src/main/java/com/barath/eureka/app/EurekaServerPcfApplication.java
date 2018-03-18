package com.barath.eureka.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPcfApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerPcfApplication.class, args);
	}
}
