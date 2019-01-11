package com.xxx.springstruts.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.xxx.springstruts.web.dao.RoleDao;
import com.xxx.springstruts.web.entity.Role;
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public Class<Role> getEntityClass() {
		return Role.class;
	}

}
