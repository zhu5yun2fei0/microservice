package com.yunfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MicroserverHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserverHystrixDashboardApplication.class, args);
	}
}
