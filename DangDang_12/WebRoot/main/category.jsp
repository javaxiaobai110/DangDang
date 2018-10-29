<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
	$(function(){
		//alert("hehe");
		//即可发送ajax异步请求把分类标题加载出来
	});
</script>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
	<!--1级分类开始-->
	<s:iterator value="#request.list" var="c">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href="${pageContext.request.contextPath}/product/showByCatId?sc=<s:property value="#c.id"/>&pageNo=1"><s:property value="#c.categoryName"/></a>]
				</h3>
				<ul class="ul_left_list">
						<!--2级分类开始-->
						<s:iterator value="#c.list">
						<li>
							<a href="${pageContext.request.contextPath}/product/showByCatId?sc=<s:property value="#c.id"/>&ssc=<s:property value="id"/>&pageNo=1"><s:property value="categoryName"/></a>
						</li>
						</s:iterator>
						<!--2级分类结束-->
				</ul>
				<div class="empty_left">
				</div>
			</div>
			<div class="more2">
			</div>
	<!--1级分类结束-->
	</s:iterator>
		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
