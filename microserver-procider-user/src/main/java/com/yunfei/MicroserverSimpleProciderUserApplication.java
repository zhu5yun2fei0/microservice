package com.yunfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserverSimpleProciderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserverSimpleProciderUserApplication.class, args);
	}
}
