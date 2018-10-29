<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<h2 class="t_xsrm">新书热卖榜</h2>
<div id="NewProduct_1_o_t" onmouseover="">
	<s:iterator value="#request.newandcreatelist">
		<ul>
			<li><a target='_blank' href="${pageContext.request.contextPath}/product/showById?id=<s:property value="id"/>"><s:property value="bookname"/></a></li>
		</ul>
	</s:iterator>
	<h3 class="second">
		<span class="dot_r"> </span><a href="JavaScript:void(0);;">更多&gt;&gt;</a>
	</h3>
</div>