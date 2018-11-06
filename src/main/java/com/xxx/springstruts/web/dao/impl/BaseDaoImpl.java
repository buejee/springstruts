package com.xxx.springstruts.web.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.springstruts.web.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	public abstract Class<T> getEntityClass();
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T entity) {
		getSession().persist(entity);
	}
	
	@Override
	public T findById(Serializable id) {
		return getSession().get(getEntityClass(), id);
	}
	
	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	@Override
	public void delete(Serializable id) {
		String hql = " from "+getEntityClass()+" where id = ?";
		Object[] params = new Object[] {id};
		executeHQL(hql, params);
	}
	
	@Override
	public void delete(Serializable... ids) {
		if(ids!=null&&ids.length>0) {
			for(Serializable id:ids) {
				delete(id);
			}
		}
	}
	@SuppressWarnings("rawtypes")
	public void executeHQL(String hql,Object[] params) {
		Query query = getSession().createQuery(hql);
		if(params!=null&&params.length>0) {
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.executeUpdate();
	}
	
	@Override
	public List<T> findAll() {
		return null;
	}
	
	@Override
	public List<T> findAllByProp(String propName, Object value) {
		return null;
	}
	
	@Override
	public List<T> findAllByProps(String[] propNames, Object[] values) {
		return null;
	}
	
	
	@Override
	public void update(T entity) {
		getSession().update(entity);
	}
}
