<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	
	<div class=second_c_02>
		<div class=second_c_02_b1>
		<s:iterator value="#request.plist">
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath}/product/showById?id=<s:property value="id"/>' target='_blank'><img src="${pageContext.request.contextPath}<s:property value="src"/>" width=70 border=0 class="imgs"/> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${pageContext.request.contextPath}/product/showById?id=<s:property value="id"/>' target='_blank' title='输赢'>书名：<s:property value="bookname"/></a>
				</h3>
				<h4>
					作者：<s:property value="author"/> 著
					<br />
					出版社：<s:property value="edition"/>&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="createdate"/>
				</h4>
				<h5>
					简介 <s:property value="format"/>
				</h5>
				<h6>
					定价：￥<s:property value="price"/>&nbsp;&nbsp;当当价：￥<s:property value="ddprice"/>
				</h6>
				<div class=line_xx></div>
			</div>
			</s:iterator>
		</div>
	</div>
		
</div>
