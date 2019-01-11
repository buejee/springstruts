package com.xxx.springstruts.web.service;
import java.io.Serializable;
import com.xxx.springstruts.web.common.Pager;
import com.xxx.springstruts.web.dao.BaseDao;
import com.xxx.springstruts.web.entity.BaseEntity;

public abstract class BaseService <E extends BaseEntity>{
	protected abstract BaseDao<E> getDao();
	public void save(E entity) {
		this.getDao().save(entity);
	}
	public void update(E entity) {
		this.getDao().update(entity);
	}
	
	public E findById(Serializable id) {
		return this.getDao().findById(id);
	}
	
	public void delete(Serializable id) {
		this.getDao().delete(id);
	}
	
	public Pager findByPager(Pager pager) {
		return this.getDao().findByPager(pager);
	}
	
}
