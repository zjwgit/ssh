package cn.itcast.web.action;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.SaleVisit;
import cn.itcast.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

public class SaleVisitAction extends ActionSupport implements ModelDriven{
	private SaleVisit SaleVisit = new SaleVisit();
	private SaleVisitService saleVisitService;
	private Integer currentPage;
	private Integer pageSize;
	public String add() throws Exception {
		//获取提交的模型
		try {
			saleVisitService.saveOrUpdate(SaleVisit);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加客户访客对象错误");

		}
		return "toList";
	}
	public String list() throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
//		if(!StringUtils.isEmpty(linkMan.getLkm_name())){
//			detachedCriteria.add(Restrictions.like("lkm_name","%"+linkMan.getLkm_name()+"%"));
//		}
		if(SaleVisit.getCustomer() != null &&SaleVisit.getCustomer().getCust_id()!=null){
			detachedCriteria.add(Restrictions.eq("customer.cust_id",SaleVisit.getCustomer().getCust_id()));
		}
		//调用service返回pagebean
		PageBean pageBean = saleVisitService.getPageBean(detachedCriteria,currentPage ,pageSize );
		//把pagebean写入vs 返回到jsp
		ActionContext.getContext().put("pageBean",pageBean);

		return "success";
	}
	public String toEdit() throws Exception {
		//根据lkm_id.查询出对象，写入，返回
		SaleVisit Li = saleVisitService.getById(SaleVisit.getVisit_id());
		ActionContext.getContext().put("saleVisit", Li);
		return "toedit";
	}

	@Override
	public Object getModel() {
		return SaleVisit;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}
}
