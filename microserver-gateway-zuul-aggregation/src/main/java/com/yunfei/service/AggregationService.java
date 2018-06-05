package com.yunfei.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yunfei.user.User;

import rx.Observable;

@Service
public class AggregationService {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallback")
	public Observable<User> getUserById(Long id){
		return Observable.create(observer ->{
			User user=restTemplate.getForObject("http://microservice-provider-user/{id}", User.class,id);
			observer.onNext(user);
			observer.onCompleted();
		});
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	public Observable<User> getMovieUserByUserId(Long id){
		return Observable.create(observer ->{
			User movieUser=restTemplate.getForObject("http://microservice-consumer-movie/user/{id}", User.class,id);
			observer.onNext(movieUser);
			observer.onCompleted();
		});
	}
	
	public User fallback(Long id) {
		User user=new User();
		user.setId(-1L);
		return user;
	}
}
