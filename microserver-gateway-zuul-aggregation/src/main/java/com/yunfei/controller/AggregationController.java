package com.yunfei.controller;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.collect.Maps;
import com.yunfei.service.AggregationService;
import com.yunfei.user.User;

import rx.Observable;
import rx.Observer;

@RestController
public class AggregationController {
	public static final Logger LOGGER=LoggerFactory.getLogger(AggregationController.class);
	
	@Autowired
	private AggregationService aggregationService;
	
	@GetMapping("/aggregate/{id}")
	public DeferredResult<HashMap<String, User>> aggregate(@PathVariable Long id){
		Observable<HashMap<String,User>> result=this.aggregateObservable(id);
		return this.toDeferredResult(result);
	}
	
	public Observable<HashMap<String, User>> aggregateObservable(Long id){
		return Observable.zip(this.aggregationService.getUserById(id), this.aggregationService.getMovieUserByUserId(id), (user,movieUser)->{
			HashMap<String, User> map=Maps.newHashMap();
			map.put("user", user);
			map.put("movieUser", movieUser);
			return map;
		});
	}
	
	public DeferredResult<HashMap<String , User>> toDeferredResult(Observable<HashMap<String, User>> details){
		DeferredResult<HashMap<String , User>> result=new DeferredResult<>();
		details.subscribe(new Observer<HashMap<String, User>>() {

			@Override
			public void onCompleted() {
				LOGGER.info("完成....");
				
			}

			@Override
			public void onError(Throwable e) {
				LOGGER.error("发生错误",e);
				
			}

			@Override
			public void onNext(HashMap<String, User> t) {
				result.setResult(t);
				
			}
			
		});
		return result;
	}
	
	
}
