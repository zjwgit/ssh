package cn.itcast.service.impl;

import cn.itcast.dao.BaseDiceDao;
import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {
	private BaseDiceDao baseDiceDao;
	@Override
	public List<BaseDict> getByTypecode(String dict_type_code) {
		return baseDiceDao.getByTypecode(dict_type_code);
	}

	public BaseDiceDao getBaseDiceDao() {
		return baseDiceDao;
	}

	public void setBaseDiceDao(BaseDiceDao baseDiceDao) {
		this.baseDiceDao = baseDiceDao;
	}
}
