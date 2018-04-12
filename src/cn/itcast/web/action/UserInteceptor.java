package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.util.Map;

public class UserInteceptor extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		//从session中取出user，如果为空，则判断未登录，转到login页面
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object user = session.get("user");
		if (user != null){
		actionInvocation.invoke();

		}
		return "toLogin";
	}
}
