package com.xxx.springstruts.web.dao.impl;
import org.springframework.stereotype.Repository;

import com.xxx.springstruts.web.dao.DiskFileDao;
import com.xxx.springstruts.web.entity.DiskFile;
@Repository
public class DiskFileDaoImpl extends BaseDaoImpl<DiskFile> implements DiskFileDao {

	@Override
	public Class<DiskFile> getEntityClass() {
		return DiskFile.class;
	}

}
