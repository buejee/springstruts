package com.xxx.springstruts.web.dao.impl;
import org.springframework.stereotype.Repository;

import com.xxx.springstruts.web.dao.UserDao;
import com.xxx.springstruts.web.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
	
	@Override
	public User findByUsername(String username) {
		String hql = "from User u where u.username = ?";
		User user = (User)getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		return user;
	}
}
