package cn.itcast.web.action;

import cn.itcast.domain.Customer;
import cn.itcast.domain.PageBean;
import cn.itcast.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import java.io.File;


public class CustomerAction extends ActionSupport implements ModelDriven {
	private Customer customer = new Customer();
	private CustomerService cs;
	private Integer currentPage;
	private Integer pageSize;
	private File photo;
	private String photoFileName;
	private String photoContentType;
	public String list() throws Exception {
		//封装detch
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		if(!StringUtils.isEmpty(customer.getCust_name())){
			detachedCriteria.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
		}
		//调用service返回pagebean
		PageBean pageBean = cs.getPageBean(detachedCriteria,currentPage ,pageSize );
		//把pagebean写入vs 返回到jsp
		ActionContext.getContext().put("pagebean",pageBean);

		return "success";
	}
	public String add() throws Exception {
		//保存后重定向到action
		//做文件上传
		if(photo != null){
			photo.renameTo(new File("E://1.jpg"));
			System.out.println(photoContentType);
		}
		cs.saveOrUpdate(customer);
		return "list";
	}


	public String toedit() throws Exception {
		//根据customerid查出目标customer，redirect request，转发到add.jsp
		 Customer c = cs.getByID(customer.getCust_id());
		 ActionContext.getContext().put("customer",c);
		return "toadd";
	}

	@Override
	public Object getModel() {
		return customer;
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerService getCs() {
		return cs;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public Customer getCustomer() {
		return customer;
	}
}
