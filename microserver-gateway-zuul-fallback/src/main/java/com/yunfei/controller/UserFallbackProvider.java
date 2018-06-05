package com.yunfei.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;


@Component
public class UserFallbackProvider implements ZuulFallbackProvider{

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return "microserver-provider-user";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			@Override
			public HttpHeaders getHeaders() {
				
				HttpHeaders headers=new HttpHeaders();
				MediaType mt=new MediaType("application","json",Charset.forName("utf-8"));
				headers.setContentType(mt);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				
				return new ByteArrayInputStream("用户微服务不可用，请稍后再试。".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				
				return this.getStatusCode().getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				
				return this.getStatusCode().value();
			}
			
			@Override
			public void close() {
				
			}
		};
	}
	
}
