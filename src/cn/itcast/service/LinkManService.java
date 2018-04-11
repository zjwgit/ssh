package cn.itcast.service;

import cn.itcast.domain.LinkMan;
import cn.itcast.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManService {
	void saveOrUpdate(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	LinkMan getById(Long lkm_id);
}
