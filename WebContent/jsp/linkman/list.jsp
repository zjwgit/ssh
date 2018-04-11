<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
    function toPage(pageNum){
        //获取表单

        $("#curr").val(pageNum);
        $("#customerForm").submit();
    }
    function changeNum(pageNum) {
        alert(pageNum);
        $("#pa").val(pageNum);
        $("#customerForm").submit();
    }
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>


		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<FORM id="customerForm" name="customerForm"
											  action="${pageContext.request.contextPath }/LinkManAction_list"
											  method=post>
											<!-- 隐藏域-->

											<input type="hidden" id="curr" name="currentPage" value="<s:property value="#pagebean.currentPage"/>">
											<input type="hidden" id="pa" name="pageSize" value="<s:property value="#pagebean.pageSize"/>">

											<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>联系人名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="lkm_name" value="<s:property value="#parameters.lkm_name"></s:property> "></TD>
													<!--style="WIDTH: 80px" maxLength=50 name="lkm_name" value="${param.lkm_name}"></TD>-->
													<td>
														<input type="hidden" name="customer.cust_id" id="c_id">
														客户名称:<input type="text" id="c_name"  name="cn" value="${param.cn}">
													</td>
													<td>
														<input type="button"  value="选择" style="width: 50px" onclick="window.open('${pageContext.request.contextPath}/CustomerAction_list?select=true','请选择客户','width=500,height=400,location=no,left=500px,top=200px')"></input>
													</td>
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
										</FORM>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator value="#pagebean.pageBean" var="linkman">
												<TR style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">

													<TD><s:property value="#linkman.lkm_name" /></TD>
													<TD><s:property value="#linkman.lkm_gender"></s:property></TD>
													<TD><s:property value="#linkman.lkm_phone"></s:property></TD>
													<TD><s:property value="#linkman.lkm_mobile"></s:property></TD>
													<TD>
													<a href="${pageContext.request.contextPath }/LinkManAction_toedit?lkm_id=<s:property value="#linkman.lkm_id"></s:property>">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/linkmanServlet?method=delete">删除</a>
													</TD>
												</TR>

												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
													style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B><s:property value="#pagebean.totalCount"/> </B>]条记录,[<B><s:property value="#pagebean.totalPage"/></B>]页
												,每页显示
												<select name="pageSize" onchange="changeNum($('#sel option:selected').val())"  id="sel">

												<option value="3" <s:property value="#pagebean.pageSize==3?'selected':''"/>>3</option>
												<option value="5" <s:property value="#pagebean.pageSize==5?'selected':''"/>>5</option>
												</select>
												条
												[<A href="javascript:void(0)" onclick="toPage(<s:property value='#pagebean.currentPage-1' />)">前一页</A>]
												<B><s:property value="#pagebean.currentPage"/></B>
												[<A href="javascript:void(0)" onclick="toPage(<s:property value='#pagebean.currentPage+1' />)">后一页</A>]
												到
												<input type="text" size="3" id="page" name="page" />
												页
												
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
	<s:debug></s:debug>
</BODY>
</HTML>
