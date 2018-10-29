<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<s:if test="#session.totalProductDdPrice == null || #session.totalProductDdPrice == 0.0">
		<%response.sendRedirect(request.getContextPath()+"/user/login_form.jsp"); %>
	</s:if>
	
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="red_bold">3.订单成功</span>
		</div>


		<div class="login_success" >
			<div class="login_bj">
				<div class="succ">
					<img src="../images/buy_success.png" />
				</div>
				<h5>
					订单已经生成
				</h5>
				<h6>
					您刚刚生成的订单号是：<span style="color:blue"><strong ><font size="5"><s:property value="#session.ordid"/></font></strong><br/></span>
					金额总计: <span style="color:blue"><strong ><font size="5">￥<s:property value="#session.totalProductDdPrice"/></font></strong></span>
				</h6>

				<ul>
					<li class="nobj">
						您现在可以：
					</li>
					<li>
						<strong><font size="4"><a href="../main/main.jsp">继续浏览并选购商品</a></font></strong>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

