package cn.itcast.service;

import cn.itcast.domain.Customer;
import cn.itcast.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	void save(Customer customer);

	Customer getByID(Long cust_id);

	void saveOrUpdate(Customer customer);
}
