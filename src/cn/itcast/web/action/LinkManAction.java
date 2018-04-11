package cn.itcast.web.action;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.domain.PageBean;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import java.io.File;


public class LinkManAction extends ActionSupport implements ModelDriven {
	private LinkMan linkMan =new LinkMan();
	private LinkManService linkManService;
	private Integer currentPage;
	private Integer pageSize;
	//添加
	public String add() throws Exception {

		linkManService.saveOrUpdate(linkMan);
		return "list";
	}
	public String list() throws Exception {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		if(!StringUtils.isEmpty(linkMan.getLkm_name())){
			detachedCriteria.add(Restrictions.like("lkm_name","%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getCustomer() != null &&linkMan.getCustomer().getCust_id()!=null){
			detachedCriteria.add(Restrictions.eq("customer.cust_id",linkMan.getCustomer().getCust_id()));
		}
		//调用service返回pagebean
		PageBean pageBean = linkManService.getPageBean(detachedCriteria,currentPage ,pageSize );
		//把pagebean写入vs 返回到jsp
		ActionContext.getContext().put("pagebean",pageBean);

		return "success";
	}
	public String toedit() throws Exception {
		//根据lkm_id.查询出对象，写入，返回
		LinkMan Li = linkManService.getById(linkMan.getLkm_id());
		ActionContext.getContext().put("linkman", Li);
		return "toedit";
	}
	@Override
	public Object getModel() {
		return linkMan;
	}

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
