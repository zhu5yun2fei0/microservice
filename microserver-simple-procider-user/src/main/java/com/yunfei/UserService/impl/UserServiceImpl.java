package com.yunfei.UserService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunfei.UserService.UserService;
import com.yunfei.dao.UserDao;
import com.yunfei.entity.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}
}
