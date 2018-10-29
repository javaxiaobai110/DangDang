<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$(function(){
				//$("#divErrorMssage").empty();
				$("#btnSignCheck").live("click", function(){
					$("#divErrorMssage").empty();
					var email = $("#txtUsername").val();
					var password = $("#txtPassowrd").val();
					var regx = /^[a-zA-Z0-9]+@\w+(\.\w+){1,2}$/;
					if($("#txtUsername").val().length == 0 | $("#txtPassowrd").val().length == 0){
						$("#divErrorMssage").text("电子邮件或密码不能为空");
						return false;
					}else if(!regx.test(email)){
						$("#divErrorMssage").html("邮箱格式不合法");
						return false;
					}else {
						return true;
					}
				});
			});
		</script>	
	</head>
	
	
	<body>


		


<div class="login_top">
	<a href="#" target="_blank"><img class="logo"
			src="../images/logo.gif" /> </a>
</div>

		<div class="enter_part">

			
<div class="introduce">
	<img src="/DangDang/images/d_introduce.gif" />
	<ul>
		<li>
			更多选择
		</li>
		<li class="bj_none">
			60万种图书音像，共计百万种商品。
		</li>
		<li>
			更低价格
		</li>
		<li class="bj_none">
			电视购物的3-5折，传统书店的5-7折，其他网站的7-9折。
		</li>
		<li>
			更方便、更安全
		</li>
		<li class="bj_none">
			全国超过300个城市送货上门、货到付款。零风险购物，便捷到家。
		</li>
	</ul>
</div>
			
			<div class="enter_in">
				<div class="bj_top">
				
				</div>
				
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red"
						id="divErrorMssage">
						<br />
						<a style="color:red" href="${pageContext.request.contextPath}/user/activeCode?id=<s:property value="#session.duserId"/>">   <s:property value="#request.loginfo"/> </a>
						<s:property value="#request.msg"/>
					</div>
					
					
					
					
					<div class="main">
						<h3>
							登录当当网
						</h3>
					
						<form id="ctl00" name="ctl00"  action="${pageContext.request.contextPath}/user/login" method="post">
						<input type="hidden" name="struts.token.name" value="struts.token" />
<input type="hidden" name="struts.token" value="GVZWV7K5B29EGS1JGU2TPAM5D7MRJVEA" />
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="duser.email" value="<s:property value="#session.activeEmail"/>" id="txtUsername" class="textbox"/>
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="duser.password" id="txtPassowrd" class="textbox" value=""/>
								</li>
								<li>
									<input type="submit" id="btnSignCheck" value="&#30331; &#24405;" class="button_enter"/>


								</li>
							</ul>
							<!-- 
							<input type="hidden" name="uri" value="" />
							 -->
						</form>




					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		
<div>
	<center>
		<hr style="height: 1px; width: 972px; color: #cfcfcf" />
		<div class="b_left"></div>
		<div class="publish_bottom_message2">
			<div class="copyright">
				Copyright (C) 当当网 2004-2008, All Rights Reserved
			</div>
			<div class="validate">
				<a
					href="#http://www.hd315.gov.cn/beian/view.asp?bianhao=010202001051000098"
					target="_blank"> <img
						src="/DangDang/images/validate.gif"
						border="0" /> </a>
				<p>
					<a href="" target="_blank">京ICP证041189号</a>
				</p>
			</div>
		</div>
	</center>
</div>

	</body>
</html>

