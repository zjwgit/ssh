package cn.itcast.dao.impl;

import cn.itcast.dao.CusotmerDao;
import cn.itcast.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CusotmerDao{


	@Override
	public void saveOrUpdate(Customer customer) {
		getHibernateTemplate().saveOrUpdate(customer);
	}
}
