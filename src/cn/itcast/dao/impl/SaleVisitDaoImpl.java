package cn.itcast.dao.impl;

import cn.itcast.dao.SaleVisitDao;
import cn.itcast.domain.SaleVisit;

public class SaleVisitDaoImpl extends BaseDaoImpl<SaleVisit> implements SaleVisitDao  {

	@Override
	public void saveOrUpdate(SaleVisit saleVisit) {
		getHibernateTemplate().saveOrUpdate(saleVisit);
	}
}
