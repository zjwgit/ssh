package cn.itcast.dao.impl;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;
import cn.itcast.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao<LinkMan> {
	@Override
	public void saveOrUpdate(LinkMan linkMan) {
		getHibernateTemplate().saveOrUpdate(linkMan);
	}


}
