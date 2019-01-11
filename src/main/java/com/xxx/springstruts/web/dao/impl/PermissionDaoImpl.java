package com.xxx.springstruts.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.xxx.springstruts.web.dao.PermissionDao;
import com.xxx.springstruts.web.entity.Permission;
@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao {
	@Override
	public Class<Permission> getEntityClass() {
		// TODO Auto-generated method stub
		return Permission.class;
	}

}
