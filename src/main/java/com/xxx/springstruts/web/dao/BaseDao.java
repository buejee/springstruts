package com.xxx.springstruts.web.dao;
import java.io.Serializable;
import java.util.List;

import com.xxx.springstruts.web.common.Pager;
public interface BaseDao<T> {
	T findById(Serializable id);
	void save(T entity);
	void update(T entity);
	void delete(T entity);
	void delete(Serializable id);
	void delete(Serializable... ids);
	void executeHQL(String hql,Object[] params);
	List<T> findAll();
	List<T> findAllByProp(String propName,Object value);
	List<T> findAllByProps(String[] propNames,Object[] values);
	Long getCount();
	Pager findByPager(Pager pager);
	
}
