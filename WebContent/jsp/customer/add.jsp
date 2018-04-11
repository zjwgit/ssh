<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE><s:property value="#customer == null?'添加':'修改'"></s:property>客户</TITLE>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script language="JavaScript">
	$(function () {

	    addSelect("006","level","cust_level.dict_id"<s:if test="#customer.cust_level!=null">,<s:property value="#customer.cust_level.dict_id" /></s:if>);
	    addSelect("002","source","cust_source.dict_id"<s:if test="#customer.cust_source!=null">,<s:property value="#customer.cust_source.dict_id" /></s:if>);
	    addSelect("001","industry","cust_industry.dict_id"<s:if test="#customer.cust_industry!=null">,<s:property value="#customer.cust_industry.dict_id" /></s:if>);
    }
	);
	//typeCode,select的父标签id，select的name(栈顶customer中BaseDict中的主键id，回显哪个（编辑的时候从customer的B中取）)
    function addSelect(typeCode,tagid,selectName,reviewId){
        //生成select元素
		var select$ = $("<select name='"+selectName+"'></select>");
        var holdS$=$("<option >--请选择--</option>");
		select$.append(holdS$);
		//生成option元素
        $.post("${pageContext.request.contextPath}/BaseDictAction", { "dict_type_code": typeCode },
            function(data){
                $.each( data, function(i, json){
					var option$ = $("<option value='"+ json.dict_id +"'>"+json.dict_item_name +"</option>");
                    if(reviewId == json.dict_id){
						option$.attr("selected","selected");
					}
					select$.append(option$);
                });
                $("#"+tagid).append(select$);
            }, "json");

    }




</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/CustomerAction_add"
		method=post enctype="multipart/form-data">
		
		<input type="hidden" name="cust_id" value="<s:property value="#customer.cust_id" />">
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
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt;<s:property value="#customer == null?'添加':'修改'"></s:property>客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>

						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_name" value="<s:property value="#customer.cust_name"></s:property>">
								</td>
								<td>客户级别 ：</td>
								<td id="level">

								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td id="source">

								</td>
								<td>客户行业：</td>
								<td id="industry">

								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="<s:property value="#customer.cust_phone"></s:property>">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="<s:property value="#customer.cust_mobile"></s:property>">
								</td>
							</TR>
							<tr>
								<td>上传图片</td>
								<td>
									<input type="file" name="photo">
								</td>

							</tr>
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
</BODY>
</HTML>
