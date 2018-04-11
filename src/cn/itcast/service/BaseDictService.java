package cn.itcast.service;

import cn.itcast.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
	//通过code返回list
	List<BaseDict> getByTypecode(String dict_type_code);
}
