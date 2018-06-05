package com.yunfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.yunfei.controller.PreRequestLogFilter;

@SpringBootApplication
@EnableZuulProxy
public class MicroserverGatewayZuulApplication {
	@Bean
	public PreRequestLogFilter preRequestLogFilter() {
		return new PreRequestLogFilter();
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroserverGatewayZuulApplication.class, args);
	}
}
