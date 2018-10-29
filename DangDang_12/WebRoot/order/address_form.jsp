<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$(function(){
				var ov = $("select option:first").val();
				$("#addressId").val(ov);
				var vid = $("#inp1").val();
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/address/showAllByDuserId",
					data:"id="+vid,
					success:function(result){
						var res = $.parseJSON(result);
						for(r in res){
							var option = $("<option value="+res[r].id+">"+res[r].detailAddress+"</value>");
							/* $("<input type='hidden' value="+res[r].reciveName+"/>");
							$("<input type='hidden' value="+res[r].detailAddress+"/>");
							$("<input type='hidden' value="+res[r].zipcode+"/>");
							$("<input type='hidden' value="+res[r].telNumber+"/>");
							$("<input type='hidden' value="+res[r].phoneNumber+"/>"); */
							$("#address").append(option);
						}
					}
				});
				
				$("#address").live("change",function(){
					$("#fullAddress").prop("readonly",false);
					$("#fullAddress").css("background","white");
					$("#postalCode").css("background","white");
					$("#postalCode").prop("readonly",false);
					var addreid = $("select option:selected").val();
					$("#addressId").val(addreid);
					if(addreid=="new"){
						$("#receiveName").val("");
						$("#fullAddress").val("");
						$("#postalCode").val("");
						$("#phone").val("");
						$("#mobile").val("");
						return;
					}
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/address/showOneById",
						data:"id="+addreid,
						success:function(result){
							var addinfo = $.parseJSON(result);
							$("#receiveName").val(addinfo.reciveName);
							$("#fullAddress").val(addinfo.detailAddress);
							$("#fullAddress").prop("readonly","readonly");
							$("#fullAddress").css("background","#c0c0c0");
							$("#postalCode").val(addinfo.zipcode);
							$("#postalCode").prop("readonly","readonly");
							$("#postalCode").css("background","#c0c0c0");
							$("#phone").val(addinfo.telNumber);
							$("#mobile").val(addinfo.phoneNumber);
							
						}
					});
					
				});
				
				$("#form1").live("submit", function(){
					if(fun1() == true & fun2() == true & fun3() == true & fun4() == true & fun5() == true){
						return true;
					}else{
						return false;
					}
				});			
				
				
				$("#receiveName").blur(function(){
					fun1();
				});
				function fun1(){
					var v = $("#receiveName").val();
					if(v.length == 0){
						$("#errName").html("<font color='red'>姓名不能为空</font>");
						return false;
					}else if(v.length < 2 || v.length > 20){
						$("#errName").html("<font color='red'>姓名长度错误,因该在2-20之间</font>");
						return false;
					}else{
						$("#errName").html("ok");
						return true;
					};
				}
				
				$("#fullAddress").blur(function(){
					fun2();
				});
				function fun2(){
					var v = $("#fullAddress").val();
					if(v.length == 0){
						$("#errAddress").html("<font color='red'>地址不能为空</font>");
						return false;
					}else if(v.length < 2 || v.length > 225){
						$("#errAddress").html("<font color='red'>地址长度错误,因该在2-225之间</font>");
						return false;
					}else{
						$("#errAddress").html("ok");
						return true;
					};
				}
				
				
				
				$("#postalCode").blur(function(){
					fun3();
				});
				function fun3(){
					var v = $("#postalCode").val();
					var regx = /^[0-9]{6}$/;
					if(v.length == 0){
						$("#errPost").html("<font color='red'>邮政编码不能为空</font>");
						return false;
					}else if(v.length < 6 | regx.test(v) == false){
						$("#errPost").html("<font color='red'>邮政编码格式错误</font>");
						return false;
					}else{
						$("#errPost").html("ok");
						return true;
					};
				}
				
				$("#phone").blur(function(){
					fun4();
				});
				function fun4(){
					var v1 = $("#phone").val();
					var v2 = $("#mobile").val();
					var regx = /^[0-9]{7}$/;
					
					
					if(v2.length == 0 && v1.length != 0){
						$("#errMobile").empty();
					}
					if(v1.length == 0 & v2.length == 0){
						$("#errPhone").html("<font color='red'>电话和手机必须填写其中之一</font>");
						return false;
					}
					if(v1.length < 7 | regx.test(v1) == false){
						if(v2.length != 0 && v1.length == 0){
							$("#errPhone").empty();
							return true;
						}
						$("#errPhone").html("<font color='red'>电话号码格式错误</font>");
						return false;
					}else{
						$("#errPhone").html("ok");
						return true;
					};
				}
				$("#mobile").blur(function(){
					fun5();
				});
				function fun5(){
					var v1 = $("#phone").val();
					var v2 = $("#mobile").val();
					var regx = /^[0-9]{11}$/;
					
					
					if(v2.length != 0 & v1.length == 0){
						$("#errPhone").empty();	
					}
					if(v1.length == 0 & v2.length == 0){
						$("#errMobile").html("<font color='red'>电话和手机必须填写其中之一</font>");
						return false;
					}
					if(v2.length != 11 | regx.test(v2) == false){
						if(v1.length != 0 && v2.length == 0){
							$("#errMobile").empty();
							return true;
						}
						$("#errMobile").html("<font color='red'>手机格式错误</font>");
						return false;
					}else{	
						$("#errMobile").html("ok");				
						return true;
					};
				};
			});
		</script>
	</head>
	<body>
		<s:if test="#session.totalProductDdPrice == null || #session.totalProductDdPrice == 0.0">
			<%response.sendRedirect(request.getContextPath()+"/user/login_form.jsp"); %>
		</s:if>
		<s:if test="#session.loginfo == null">
			<%response.sendRedirect(request.getContextPath()+"/user/login_form.jsp"); %>
		</s:if>
		
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 &gt;
			<span class="red_bold"> 2.填写送货地址</span> &gt; 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address">
					<option value="new">
						填写新地址
					</option>
				</select>
				
			</p>
			
			
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/order/orderAdd" id="form1">
				<input type="hidden" name="address.id" id="addressId" />
				<input id="inp1" type="hidden" name="duserId" value="<s:property value="#session.duserId"/>"/>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text"  class="text_input" name="address.reciveName"
								id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名(长度2-20)<br />
									<span id="errName" class="infoError" style="color:green;"></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="address.detailAddress" class="text_input"
								id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址(长度2-225)<br />
									<span id="errAddress" class="infoError" style="color:green;"></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="address.zipcode"
								id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码(长度6)<br />
									<span id="errPost" class="infoError" style="color:green;"></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="address.telNumber"
								id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话(长度7)<br />
									<span id="errPhone" class="infoError"></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" class="text_input" name="address.phoneNumber"
								id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机(长度11)<br />
									<span id="errMobile" class="infoError" style="color:green;"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="../order/order_info.jsp"><input id="btnClientRegister" class="button_1" name="button"
					type="button" value="取消" /></a>
			
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

