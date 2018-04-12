package cn.itcast.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	
	private UserService userService ;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
			//1 调用Service执行登陆逻辑
			User u = userService.getUserByCodePassword(user);
			//2 将返回的User对象放入session域
			ActionContext.getContext().getSession().put("user", u);
			//3 重定向到项目首页
		return "toHome";
	}
	public String register() throws Exception {
		//根据用户名获取用户，如果用户不为空，证明已经存在，注册失败，写错误信息，转到register.jsp
		User exsitU = userService.getUserByCode(user.getUser_code());
		String result="index";
		if (exsitU!=null){
			ActionContext.getContext().put("error","用户名已经存在");
			return "register";

		}
		userService.saveUser(user);
		return result;
	}

	@Override
	public User getModel() {
		return user;
	}

	
	
}
