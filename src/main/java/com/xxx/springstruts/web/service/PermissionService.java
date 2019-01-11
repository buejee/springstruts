package com.xxx.springstruts.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.springstruts.web.dao.BaseDao;
import com.xxx.springstruts.web.dao.PermissionDao;
import com.xxx.springstruts.web.entity.Permission;
@Service
public class PermissionService extends BaseService<Permission>{
	@Autowired
	private PermissionDao permissionDao;

	@Override
	protected BaseDao<Permission> getDao() {
		return permissionDao;
	}
	
}
