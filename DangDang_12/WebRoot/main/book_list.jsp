<%@page contentType="text/html;charset=utf-8" isELIgnored="false" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta content="text/html;charset=utf-8" http-equiv="Content-type	"/>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js">
		</script>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="JavaScript:void(0);"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/main/main.jsp'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'>
					<s:if test="ssc==null">
						<strong >
							<a style="color:red" href="${pageContext.request.contextPath}/product/showByCatId?sc=<s:property value="sc"/>&pageNo=1"><s:property value="category.categoryName"/></a>
						</strong> 
					</s:if>
					<s:else>
						<a  href="${pageContext.request.contextPath}/product/showByCatId?sc=<s:property value="sc"/>&pageNo=1"><s:property value="category.categoryName"/></a>
					</s:else>
			</font> &gt;&gt;
			<s:iterator value="category.list">
				<font style='color: #cc3300'>
						<s:if test="ssc==id">
							<strong>
								<s:property value="categoryName"/>
							</strong> 
						</s:if>
				</font>
			</s:iterator>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
								
									<div class=second_fenlei <s:if test="ssc==null">style="color:red"</s:if> >
										&middot;全部&nbsp;(10000000)
									</div>
								
								</div>
							</li>
							<div class="clear"></div>
							<s:iterator value="category" var="c">
							<!--2级分类开始-->
								<s:iterator value="#c.list">
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										
										<s:if test="ssc==id">
											<div class=second_fenlei >
												<a style="color:red;" href="${pageContext.request.contextPath}/product/showByCatId?sc=<s:property value="#c.id"/>&ssc=<s:property value="id"/>&pageNo=1"> <s:property value="categoryName"/>&nbsp;<b class="b1">(<s:property value="id"/>)</b></a>
											</div>
										</s:if>
										<s:else>
											<div class=second_fenlei>
												<a  href="${pageContext.request.contextPath}/product/showByCatId?sc=<s:property value="#c.id"/>&ssc=<s:property value="id"/>&pageNo=1"> <s:property value="categoryName"/>&nbsp;<b class="b1">(<s:property value="id"/>)</b></a>
											</div>
										</s:else>
									</div>
								</li>
							    <div class="clear"></div>
							    </s:iterator>
							</s:iterator>
							<!--2级分类结束-->
							
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->
			
			
			
			

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<s:if test="pageNo>1">
								<div class='list_r_title_text3a'>
									<a name=link_page_next
										href="${pageContext.request.contextPath}/product/showByCatId?sc=<s:property value="sc"/>&ssc=<s:property value="ssc"/>&pageNo=<s:property value="pageNo-1"/>">
									<img src='../images/page_up.gif' /> </a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_up_gray.gif' />
								</div>
							</s:else>
							
							
							
								<div class='list_r_title_text3b'>
									<s:if test="allCount==0">
										第1页/共1页
									</s:if>
									<s:else>
										第<s:property value="pageNo"/>页/共<s:property value="allCount"/>页
									</s:else>
								</div>
							
							
							<s:if test="pageNo<allCount">
								<div class='list_r_title_text3a'>
									<a name=link_page_next
										href="${pageContext.request.contextPath}/product/showByCatId?sc=<s:property value="sc"/>&ssc=<s:property value="ssc"/>&pageNo=<s:property value="pageNo+1"/>">                            
										<img src='../images/page_down.gif' /> </a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_down_gray.gif' />
								</div>
							</s:else>
							
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<s:iterator value="list">
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='${pageContext.request.contextPath}/product/showById?id=<s:property value="id"/>'>
								<img src="${pageContext.request.contextPath}<s:property value="src"/>" width="70px"  border=1></img> </a> </span>
							<h2>
								<a name="link_prd_name" href='${pageContext.request.contextPath}/product/showById?id=<s:property value="id"/>'><s:property value="bookname"/></a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者: <s:property value="price"/>
								<a href='#' name='作者'>菜鸟</a>
							</h4>
							<h4>
								出版社： <s:property value="edition"/>
								<a href='#' name='出版社'>人民邮电出版社</a>
							</h4>
							<h4>
								出版时间：<s:property value="printtime"/>
							</h4>
							<h5>
								这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥<s:property value="price"/></span>
								<span class="red">￥<s:property value="ddprice"/></span>
								节省：￥<s:property value="price-ddprice"/>
							</h6>
							<span class="list_r_list_button"> 
							<a href="${pageContext.request.contextPath}/cart/cartAdd?id=<s:property value="id"/>"> 
							<img src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
						</s:iterator>																			
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
