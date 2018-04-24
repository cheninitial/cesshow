package com.yuanliang.chen.discoveryeureka002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryEureka002Application {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryEureka002Application.class, args);
	}
}
