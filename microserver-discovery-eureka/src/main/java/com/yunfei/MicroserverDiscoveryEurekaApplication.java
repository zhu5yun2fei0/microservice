package com.yunfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserverDiscoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserverDiscoveryEurekaApplication.class, args);
	}
}
