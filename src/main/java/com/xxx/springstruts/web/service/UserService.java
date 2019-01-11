package com.xxx.springstruts.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.springstruts.web.dao.BaseDao;
import com.xxx.springstruts.web.dao.UserDao;
import com.xxx.springstruts.web.entity.User;
@Service
public class UserService extends BaseService<User>{
	@Autowired
	private UserDao userDao;
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	protected BaseDao<User> getDao() {
		return userDao;
	}
}
