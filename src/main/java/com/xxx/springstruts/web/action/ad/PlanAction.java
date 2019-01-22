package com.xxx.springstruts.web.action.ad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.springstruts.web.entity.User;
import com.xxx.springstruts.web.service.UserService;

public class PlanAction {
	private static final Logger log = LoggerFactory.getLogger(PlanAction.class);
	@Autowired
	private UserService userService;
	public String list() {
		User user = userService.findById(1);
		log.info("user : "+user.getUsername());
		return "list";
	}
	
	public String upload() {
		return "upload";
	}
}
