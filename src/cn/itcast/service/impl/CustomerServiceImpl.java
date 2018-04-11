package cn.itcast.service.impl;

import cn.itcast.dao.CusotmerDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.PageBean;
import cn.itcast.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
	private CusotmerDao dao;

	public CusotmerDao getDao() {
		return dao;
	}

	public void setDao(CusotmerDao dao) {
		this.dao = dao;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		Integer totalCount = dao.getTotalCount(detachedCriteria);
		PageBean<Customer> bean = new PageBean<>(currentPage,pageSize,totalCount);
		List<Customer> list = dao.getPageBean(detachedCriteria, bean.getStart(), bean.getPageSize());
		bean.setPageBean(list);
		return bean;
	}

	@Override
	public void save(Customer customer) {
		dao.save(customer);
	}

	@Override
	public Customer getByID(Long cust_id) {
		return dao.getById(cust_id);
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		dao.saveOrUpdate(customer);
	}
}
