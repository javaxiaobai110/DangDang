<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<h2>
	<span class="more"><a href="javascript:void(0)" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">
	<s:iterator value="#request.sallist">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/product/showById?id=<s:property value="id"/>" target='_blank'>
			<img src="${pageContext.request.contextPath}<s:property value="src"/>" border=0 class="imgs"/> </a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/product/showById?id=<s:property value="id"/>" target="_blank"><s:property value="bookname"/></a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥<s:property value="price"/>
		</div>
		<div class="price">
			当当价：￥<s:property value="ddprice"/>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
	</s:iterator>
</div>
<div class="clear"></div>