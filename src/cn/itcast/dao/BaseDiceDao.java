package cn.itcast.dao;

import cn.itcast.domain.BaseDict;

import java.util.List;

public interface BaseDiceDao<BaseDict> extends BaseDao<BaseDict>{
	List<BaseDict> getByTypecode(String dict_type_code);
}
