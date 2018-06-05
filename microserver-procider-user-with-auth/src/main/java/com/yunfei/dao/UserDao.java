package com.yunfei.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yunfei.entity.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User getUser(Long id) {
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		User user=jdbcTemplate.queryForObject("select * from user where id=?", rowMapper,id);
		return user;
	}
	
}
