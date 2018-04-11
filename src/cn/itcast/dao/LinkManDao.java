package cn.itcast.dao;

import cn.itcast.domain.LinkMan;
import cn.itcast.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManDao<LinkMan> extends  BaseDao<LinkMan>{
	void saveOrUpdate(LinkMan linkMan);


}
