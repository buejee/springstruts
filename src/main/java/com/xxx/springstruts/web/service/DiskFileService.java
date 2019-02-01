package com.xxx.springstruts.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.springstruts.web.dao.BaseDao;
import com.xxx.springstruts.web.dao.DiskFileDao;
import com.xxx.springstruts.web.entity.DiskFile;

@Service
public class DiskFileService extends BaseService<DiskFile> {

	@Autowired
	private DiskFileDao diskFileDao;
	
	@Override
	protected BaseDao<DiskFile> getDao() {
		return diskFileDao;
	}

}
