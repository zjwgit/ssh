package cn.itcast.dao;

import cn.itcast.domain.SaleVisit;

public interface SaleVisitDao extends BaseDao<SaleVisit> {


	void saveOrUpdate(SaleVisit saleVisit);
}
