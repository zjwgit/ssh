package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisitService {
	void saveOrUpdate(SaleVisit saleVisit);

	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	SaleVisit getById(String visit_id);

}
