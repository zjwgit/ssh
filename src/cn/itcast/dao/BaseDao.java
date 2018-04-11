package cn.itcast.dao;

import cn.itcast.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    //增
	void save(T t);
    //删根据id
	void delete(Serializable id);
    //删根据对象
    void delete(T t);
    //改
	void update(T t);
    //查 根据id
	T getById(Serializable id);
    //查 总计录数
	Integer getTotalCount(DetachedCriteria dc);
    //增 查分页数据返回配置bean
	List<T> getPageBean(DetachedCriteria dc, int start, int pageSize);
}
