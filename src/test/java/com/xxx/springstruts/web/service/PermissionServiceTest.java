package com.xxx.springstruts.web.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.springstruts.web.common.Pager;
import com.xxx.springstruts.web.entity.Permission;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class PermissionServiceTest {
	@Autowired
	private PermissionService permissionService;
	@Test
	public void save() {
		Permission entity = new Permission();
		entity.setName("营销数据管理");
		entity.setIsMenu(1);
		entity.setLevel(1);
		permissionService.save(entity);
	}
	
	@Test
	public void query() {
		Pager pager = permissionService.findByPager(new Pager());
		System.out.println(pager.getPageCount());
		Assert.assertEquals(pager.getTotal(), 1);
	}
}
