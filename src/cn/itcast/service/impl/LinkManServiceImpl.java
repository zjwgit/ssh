package cn.itcast.service.impl;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;
import cn.itcast.domain.PageBean;
import cn.itcast.service.LinkManService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDao linkManDao;
	@Override
	public void saveOrUpdate(LinkMan linkMan) {
		linkManDao.saveOrUpdate(linkMan);

	}

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		Integer totalCount = linkManDao.getTotalCount(detachedCriteria);
		PageBean<LinkMan> bean = new PageBean<>(currentPage,pageSize,totalCount);
		List<LinkMan> list = linkManDao.getPageBean(detachedCriteria, bean.getStart(), bean.getPageSize());
		bean.setPageBean(list);
		return bean;
	}

	@Override
	public LinkMan getById(Long lkm_id) {
		return (LinkMan) linkManDao.getById(lkm_id);
	}

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
}
