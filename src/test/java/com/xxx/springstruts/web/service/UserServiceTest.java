package com.xxx.springstruts.web.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.springstruts.web.entity.Role;
import com.xxx.springstruts.web.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class UserServiceTest {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@Test
	public void save() {
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("123456");
		user.setMobile("15910909520");
		user.setStatus(1);
		userService.save(user);
	}
	
	@Test
	public void query() {
		User user = userService.findById(3);
		System.out.println(user.getUsername());
		Role role = roleService.findById(3);
		System.out.println(role.getName());
		user.setRole(role);
		userService.update(user);
		Assert.assertEquals("zhangsan", user.getUsername());
	}
}
