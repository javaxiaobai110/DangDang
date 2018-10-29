<%@page contentType="text/html;charset=utf-8" isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		
		<script type="text/javascript">
			$(function(){
				$("#f1").live("submit",function(){
					var a1 = $("#emailInfo").text().trim();
					var a2 = $("#codeinfo").text().trim();
					if(a1=="ok" & a2=="ok" & fun3() == true & fun4() == true & fun5() == true){
						return true;
					}else{
						return false;
					}
				});
				
				
				$("#a1").click(function(){
					$("#img1").prop("src","${pageContext.request.contextPath}/user/image?time="+new Date());
					
					/* $.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/user/image",
						success:function(result){
							$("#img1").prop("src","${pageContext.request.contextPath}/user/image");
						}
					}); */
				});
				
				$("#inpemail").blur(function(){fun1();});
				
				function fun1(){
					
					var email = $("#inpemail").val();
					var regx = /^[a-zA-Z0-9]+@\w+(\.\w+){1,2}$/;
					$("#emailInfo").empty();
					if(email.length == 0){
						$("#emailInfo").append("<font color='red'>邮箱不能为空</font>");
						return false;
					}else if(!regx.test(email)){
						$("#emailInfo").append("<font color='red'>邮箱格式不合法</font>");
						return false;
					}
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/user/findOneUserInfo",
						data:"email="+email,
						success:function(result){
							if($.trim(result)=='ok'){
								$("#emailInfo").text(result);
							}	
							else{
								$("#emailInfo").append("<font color='red'>"+result+"</font>");
							}
						}
					});
					
					
					
				}
				
				$("#inp1").blur(function(){return fun2();});
				
				function fun2(){
					var v = $("#inp1").val();
					$("#codeinfo").empty();
					if(v.length == 0){
						$("#codeinfo").append("<font color='red'>验证码不能为空</font>");
						return false;
					}
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/user/checkcode",
						data:"code="+v,
						success:function(result){
							
							if(result.trim() != 'ok'){
								$("#codeinfo").html("<font color='red'>"+result+"</font>");
								return false;
							}else{
								$("#codeinfo").html(result);
								return true;
							}
							
						}
					});
				
				}
				
				
				$("#inpname").live("blur",function(){return fun3();});
				
				function fun3(){
					$("#nameInfo").empty();
					var v = $("#inpname").val();
					if(v.length == 0){
						$("#nameInfo").append("<font color='red'>昵称不能为空</font>");	
						return false;
					}else if(v.length < 4 | v.length > 20){
						$("#nameInfo").append("<font color='red'>昵称不合法</font>");
						return false;
					}else{
						$("#nameInfo").text("ok");
						return true;
					};
				};
				
				$("#inppass1").live("blur",function(){return fun4();});
				
				function fun4(){
					$("#passwordInfo").empty();
					var v = $("#inppass1").val();
					if(v.length == 0){
						$("#passwordInfo").append("<font color='red'>密码不能为空</font>");
						return false;
					}else if(v.length < 6 | v.length > 20){
						$("#passwordInfo").append("<font color='red'>密码不合法</font>");
						return false;
					}else{
						$("#passwordInfo").text("ok");
						return true;
					};
				}
				
				$("#inppass2").live("blur",function(){return fun5();});
				
				function fun5(){
					$("#password1Info").empty();
					var v1 = $("#inppass2").val();
					var v2 = $("#inppass1").val();
					if(v1.length==0){
						$("#password1Info").append("<font color='red'>确认密码不能为空</font>");	
						return false;
					}else if(v1!=v2){
						$("#password1Info").append("<font color='red'>两次密码不一致</font>");
						return false;
					}else{
						$("#password1Info").text("ok");
						return true;
					};
				};
				
			});
		</script>
  </head>
  
  <body>
		


<div class="login_top">
	<a href="#" target="_blank"><img class="logo"
			src="../images/logo.gif" /> </a>
</div>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> &gt; 2.验证邮箱 &gt; 3.注册成功
		</div>
		<div class="fill_message">
			<form id="f1" name="ctl00" action="${pageContext.request.contextPath}/user/register" method="post">
			<input type="hidden" name="struts.token.name" value="struts.token" />
<input type="hidden" name="struts.token" value="F578MMBX7UOG76HGSWQNFMYRW5U89EEI" />
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input type="text" name="duser.email" value="" id="inpemail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="emailInfo" style="color:green;">
									&nbsp;
									</span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input type="text" name="duser.nickName" value="" id="inpname" class="text_input"/>
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo" style="color:green">
								&nbsp;
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input type="password" name="duser.password" id="inppass1" class="text_input"/>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo" style="color:green;">
								&nbsp;
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input type="password" name="password1" id="inppass2" class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="password1Info" style="color:green;">
							&nbsp;
							</span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td height="55px">
							<input type="text" name="validateCode" id="inp1" class="yzm_input"  size="2"/>
							<div class="text_left t1">
								<p>
									<img id="img1" src="${pageContext.request.contextPath}/user/image" width="100" height="30"/> &nbsp;
									<span id="vcodeValidMsg" style="position: absolute;">请输入图片中的四个字母。</span>
									<a href="javascript:void(0);;" id="a1">看不清，再换一张</a>
								</p>
								<p>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="codeinfo" style="color:green;"></span>
								</p>
								
							</div>
							
						</td>
					</tr>
				</table>

				<div class="login_in">
					<input type="submit" id="inp3" value="&#27880;&#20876;" class="button_1"/>

				</div>
				
			</form>




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

