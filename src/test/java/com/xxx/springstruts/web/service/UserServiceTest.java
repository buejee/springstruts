package com.xxx.springstruts.web.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.springstruts.web.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void save() {
		User user = userService.findById(1);
		Assert.assertEquals("yyy", user.getUsername());
	}
}
