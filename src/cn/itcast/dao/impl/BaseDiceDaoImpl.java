package cn.itcast.dao.impl;

import cn.itcast.dao.BaseDiceDao;
import cn.itcast.domain.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;


import java.util.List;


public class BaseDiceDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDiceDao<BaseDict>{
	@Override
	public List<BaseDict> getByTypecode(String dict_type_code) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BaseDict.class);
		DetachedCriteria criteria = detachedCriteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
}
