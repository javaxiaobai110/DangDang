<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$(function(){
				
				$(".a1").live("click",function(){
					
					var count = $(this).prev().val();
					//alert(count);
					var id = $(this).next().val();
					var count1 = $(this).parent().prev().text();
					if(count1.trim()==count){
						//alert("heh");
						return false;
					}else{
						$(this).prop("href","${pageContext.request.contextPath}/cart/cartUpdate?id="+id+"&count="+count);
					}
				});
			});
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />

		</div>
		<s:if test="#session.map!=null && #session.map.size>0">
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
				
					<s:iterator value="#session.map">
                      <!-- 购物列表开始 -->
						<tr class='td_no_bord'>
							<td style='display: none'>
								9317290
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="#"><s:property value="value.dbook.bookname"/></a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥<s:property value="value.dbook.price"/></span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥<s:property value="value.dbook.ddprice"/></span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;<s:property value="value.count"/>
							</td>

							<td >
								<input id="inps1" class="del_num" type="text" size="3" maxlength="4" value="<s:property value="value.count"/>"/>
								<a  class="a1">变更</a>
								<input type="hidden" value="<s:property value="key"/>"/>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/cart/cartUpdate?id=<s:property value="key"/>&count=0">删除</a>
							</td>
						</tr>
					</s:iterator>
					
					<!-- 购物列表结束 -->
				
				</table>
				
				
				
				
				
				
				
				
				
				
				
				<div id="div_no_choice" class="objhide">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy"><s:property value="#session.totalProductSavePrice"/></span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'><s:property value="#session.totalProductDdPrice"/></span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='../order/order_info.jsp' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</s:if>
		
		
	<s:else>
		<div id="div_no_choice">
				<div class="choice_title"></div>
				<div class="no_select">
					您还没有挑选商品<a href='${pageContext.request.contextPath}/main/main.jsp'> 继续挑选商品&gt;&gt;</a>
				</div>
		</div>
	</s:else>
	 	
		
		<!-- 用户删除恢复区 -->

		<s:if test="#session.recmap!=null && #session.recmap.size>0">
		
		 <div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>

				<s:iterator value="#session.recmap">
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#"><s:property value="value.dbook.bookname"/></a>
						</td>
						<td width="106" class=buy_td_5>
							￥<s:property value="value.dbook.price"/>
						</td>
						<td width="134" class=buy_td_4>
							<span>￥<s:property value="value.dbook.ddprice"/></span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="${pageContext.request.contextPath}/cart/cartRecov?id=<s:property value="key"/>&count=<s:property value="#session.reccount"/>">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
				</s:iterator>
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
				
				</tbody>
			</table>
		</div> 
		
		</s:if>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



