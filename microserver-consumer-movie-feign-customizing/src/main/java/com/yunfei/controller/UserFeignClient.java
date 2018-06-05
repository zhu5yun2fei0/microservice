package com.yunfei.controller;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.yunfei.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="microservice-provider-user",configuration=FeignConfiguration.class)
public interface UserFeignClient {
	@RequestLine("GET /{id}")
	public User findById(@Param("id") Long id);
}
