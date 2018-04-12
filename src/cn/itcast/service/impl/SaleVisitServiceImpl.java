package cn.itcast.service.impl;

import cn.itcast.dao.SaleVisitDao;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.SaleVisit;
import cn.itcast.service.SaleVisitService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDao dao;
	@Override
	public void saveOrUpdate(SaleVisit saleVisit) {
		dao.saveOrUpdate(saleVisit);
	}

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		Integer total = dao.getTotalCount(detachedCriteria);
		PageBean<SaleVisit> pageBean = new PageBean<>(currentPage,pageSize,total);
		List<SaleVisit> bean = dao.getPageBean(detachedCriteria, pageBean.getStart(), pageBean.getPageSize());
		pageBean.setPageBean(bean);
		return pageBean;
	}

	@Override
	public SaleVisit getById(String visit_id) {
		return dao.getById(visit_id);
	}

	public void setDao(SaleVisitDao dao) {
		this.dao = dao;
	}
}
