package cn.itcast.web.action;

import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BaseDictAction extends ActionSupport {
	private BaseDictService baseDictService;
	private String dict_type_code;
	@Override
	public String execute() throws Exception {
		//根据dict_type_code获取BaseDict的list并组装为json
		List<BaseDict> list = baseDictService.getByTypecode(dict_type_code);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return null;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
}
