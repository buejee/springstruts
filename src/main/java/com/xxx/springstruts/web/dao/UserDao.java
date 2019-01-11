package com.xxx.springstruts.web.dao;
import com.xxx.springstruts.web.entity.User;
public interface UserDao extends BaseDao<User>{
	public User findByUsername(String username);
}
