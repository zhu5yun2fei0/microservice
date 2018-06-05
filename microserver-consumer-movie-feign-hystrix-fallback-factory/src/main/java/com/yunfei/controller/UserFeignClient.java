package com.yunfei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunfei.entity.User;

import feign.hystrix.FallbackFactory;

@FeignClient(name="microservice-provider-user",fallbackFactory=FeignClientFallbackFactory.class)
public interface UserFeignClient {
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
	private static final Logger LOGGER=LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient() {
			
			@Override
			public User findById(Long id) {
				FeignClientFallbackFactory.LOGGER.info("-----------------返回了;reason was:",cause);
				User user=new User();
				user.setId(-1L);
				user.setName("默认用户");
				return user;
			}
		};
	}
}