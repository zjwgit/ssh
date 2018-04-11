package cn.itcast.dao;

import cn.itcast.domain.Customer;

public interface CusotmerDao extends BaseDao<Customer> {
	void saveOrUpdate(Customer customer);
}
