package cn.itcast.dao.impl;

import cn.itcast.dao.BaseDao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] arguments = superclass.getActualTypeArguments();
		clazz = (Class) arguments[0];
	}

	@Override
	public void save(Object o) {
		getHibernateTemplate().save(o);
	}

	@Override
	public void delete(Serializable id) {
		Object o = getHibernateTemplate().get(clazz, id);
		getHibernateTemplate().delete(o);
	}

	@Override
	public void delete(Object o) {
		getHibernateTemplate().delete(o);
	}

	@Override
	public void update(Object o) {
		  getHibernateTemplate().update(o);
	}

	@Override
	public T getById(Serializable id) {
		return getHibernateTemplate().get((Class<T>) clazz,id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		DetachedCriteria criteria = dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		dc.setProjection(null);
		if(list != null && list.size()>0){
			 return list.get(0).intValue();
		}

		return null;
	}

	@Override
	public List<T> getPageBean(DetachedCriteria dc, int start, int pageSize) {
		
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);

		return list;
	}
}
