package com.xxx.springstruts.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.springstruts.web.dao.BaseDao;
import com.xxx.springstruts.web.dao.RoleDao;
import com.xxx.springstruts.web.entity.Role;
@Service
public class RoleService extends BaseService<Role> {
	@Autowired
	private RoleDao roleDao;

	@Override
	protected BaseDao<Role> getDao() {
		return roleDao;
	}

}
