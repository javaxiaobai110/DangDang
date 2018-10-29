package com.baizhi.dangdang.cart.serviceImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.baizhi.dangdang.cart.service.CartService;
import com.baizhi.dangdang.entity.CartItem;
import com.baizhi.dangdang.entity.Dbook;
import com.baizhi.dangdang.product.dao.ProductDao;
import com.baizhi.dangdang.util.MybatisUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class CartServiceImpl implements CartService{

	@Override
	public void cartAdd(String id) {
		ValueStack vs = ActionContext.getContext().getValueStack();
		Map<String, CartItem> map = (Map<String, CartItem>) vs.findValue("#session.map");
		if(map==null){
			Map<String, CartItem> maps = new HashMap<String,CartItem>();
			ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
			Dbook dbook = dao.queryById(id);
			CartItem cartItem = new CartItem(dbook,1,dbook.getPrice(),dbook.getDdprice());
			maps.put(id, cartItem);
			vs.setValue("#session.map", maps);
			vs.setValue("#session.totalProductDdPrice", cartItem.getDdPrice());//所有商品累计当当价
			vs.setValue("#session.totalProductSavePrice", cartItem.getPrice()-cartItem.getDdPrice());//所有商品累计省钱多少
		}else{
			if(map.containsKey(id)){
				CartItem cartItem = map.get(id);
				cartItem.setCount(cartItem.getCount()+1);
				cartItem.setPrice(cartItem.getCount()*cartItem.getDbook().getPrice());//一种书市场总价
				cartItem.setDdPrice(cartItem.getCount()*cartItem.getDbook().getDdprice());//一种书当当价
				map.put(id, cartItem);
				Collection<CartItem> coll = map.values();
				Double totalProductDdPrice = 0.0;
				Double totalProductSavePrice = 0.0;
				for(CartItem ct : coll){
					totalProductDdPrice += ct.getDdPrice();
					totalProductSavePrice += ct.getPrice() - ct.getDdPrice();
				}
				vs.setValue("#session.map", map);
				vs.setValue("#session.totalProductDdPrice", totalProductDdPrice);
				vs.setValue("#session.totalProductSavePrice", totalProductSavePrice);
			}else{
				Integer reccount = (Integer) vs.findValue("#session.reccount");
				Map<String,CartItem> recmap = (Map<String, CartItem>) vs.findValue("#session.recmap");
				if(recmap!=null){
					if(recmap.containsKey(id)){
						recmap.remove(id);
						vs.setValue("#session.recmap", recmap);
					}
				}
				
				if(reccount==null){
					reccount = 0;
				}
				ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
				Dbook dbook = dao.queryById(id);
				CartItem cartItem = new CartItem(dbook,1+reccount,dbook.getPrice()*(1+reccount),dbook.getDdprice()*(1+reccount));
				map.put(id, cartItem);
				vs.setValue("#session.map", map);
				Double totalProductDdPrice = (Double) vs.findValue("#session.totalProductDdPrice");
				Double totalProductSavePrice = (Double) vs.findValue("#session.totalProductSavePrice");
				vs.setValue("#session.totalProductDdPrice", totalProductDdPrice+cartItem.getDdPrice());
				vs.setValue("#session.totalProductSavePrice", totalProductSavePrice+(cartItem.getPrice()-cartItem.getDdPrice()));
			}
		}
	}

	@Override
	public void cartUpdate(String id, Integer count) {
		ValueStack vs = ActionContext.getContext().getValueStack();
		
		Map<String, CartItem> map = (Map<String, CartItem>) vs.findValue("#session.map");
		CartItem cartItem = map.get(id);
		
		if(count==0){
			Map<String, CartItem> recmap = (Map<String, CartItem>) vs.findValue("#session.recmap");
			if(recmap==null){
				Map<String, CartItem> recmaps = new HashMap<String, CartItem>();
				recmaps.put(id, cartItem);
				vs.setValue("#session.recmap", recmaps);
				vs.setValue("#session.recprice", cartItem.getDbook().getPrice());
				vs.setValue("#session.recdprice", cartItem.getDbook().getDdprice());
				vs.setValue("#session.reccount", cartItem.getCount());
			}else{
				recmap.put(id, cartItem);
				vs.setValue("#session.recmap", recmap);
				vs.setValue("#session.recprice", cartItem.getDbook().getPrice());
				vs.setValue("#session.recdprice", cartItem.getDbook().getDdprice());
				vs.setValue("#session.reccount", cartItem.getCount());
			}
			cartItem.setCount(count);
			map.remove(id);
			vs.setValue("#session.map", map);
			Double totalProductDdPrice = (Double) vs.findValue("#session.totalProductDdPrice");
			Double totalProductSavePrice = (Double) vs.findValue("#session.totalProductSavePrice");
			//System.out.println(cartItem.getDdPrice()+"********");
			vs.setValue("#session.totalProductDdPrice", totalProductDdPrice-cartItem.getDdPrice());
			vs.setValue("#session.totalProductSavePrice", totalProductSavePrice-(cartItem.getPrice()-cartItem.getDdPrice()));
			
		}else{
			if(cartItem.getCount()<count){
				//System.out.println(count+"-------------------------");
				cartItem.setCount(count);
				cartItem.setPrice(cartItem.getDbook().getPrice()*cartItem.getCount());
				cartItem.setDdPrice(cartItem.getDbook().getDdprice()*cartItem.getCount());
				map.put(id, cartItem);
				vs.setValue("#session.map", map);
				Double totalProductDdPrice = 0.0;
				Double totalProductSavePrice = 0.0;
				if(map.size()>1){
					totalProductDdPrice = (Double) vs.findValue("#session.totalProductDdPrice");
					totalProductSavePrice = (Double) vs.findValue("#session.totalProductSavePrice");
					//System.out.println(totalProductDdPrice+"......."+totalProductSavePrice);
					//System.out.println(cartItem.getDdPrice()+"aaaaaaaaaaa"+cartItem.getDbook().getDdprice()*(count-1));
					vs.setValue("#session.totalProductDdPrice", totalProductDdPrice+cartItem.getDdPrice()-cartItem.getDbook().getDdprice());
					vs.setValue("#session.totalProductSavePrice", totalProductSavePrice+(cartItem.getPrice()-cartItem.getDdPrice()-( (cartItem.getDbook().getPrice() - cartItem.getDbook().getDdprice()) ) ));
				}else{
					vs.setValue("#session.totalProductDdPrice", totalProductDdPrice+cartItem.getDdPrice());
					vs.setValue("#session.totalProductSavePrice", (cartItem.getPrice()-cartItem.getDdPrice()));
				}
				
			}else{
				//System.out.println("hehehehdadadadadada--------------");
				
				Double totalProductDdPrice = 0.0;
				Double totalProductSavePrice = 0.0;
				if(map.size()>1){
					totalProductDdPrice = (Double) vs.findValue("#session.totalProductDdPrice");
					totalProductSavePrice = (Double) vs.findValue("#session.totalProductSavePrice");
					//System.out.println(totalProductDdPrice+"......."+totalProductSavePrice);
					//System.out.println(totalProductDdPrice+"bbbbbbbb"+cartItem.getDdPrice()*count);
					vs.setValue("#session.totalProductDdPrice", totalProductDdPrice-cartItem.getDdPrice()+cartItem.getDbook().getDdprice());
					//System.out.println(cartItem.getPrice()+"ccccccccccc"+cartItem.getDdPrice());
					vs.setValue("#session.totalProductSavePrice", totalProductSavePrice-(cartItem.getPrice()-cartItem.getDdPrice())+ ( cartItem.getDbook().getPrice() - cartItem.getDbook().getDdprice() ));
					cartItem.setCount(count);
					cartItem.setPrice(cartItem.getDbook().getPrice()*cartItem.getCount());
					cartItem.setDdPrice(cartItem.getDbook().getDdprice()*cartItem.getCount());
					map.put(id, cartItem);
					vs.setValue("#session.map", map);
				}else{
					cartItem.setCount(count);
					cartItem.setPrice(cartItem.getDbook().getPrice()*cartItem.getCount());
					cartItem.setDdPrice(cartItem.getDbook().getDdprice()*cartItem.getCount());
					map.put(id, cartItem);
					vs.setValue("#session.totalProductDdPrice", cartItem.getDdPrice());
					vs.setValue("#session.totalProductSavePrice", cartItem.getPrice() - cartItem.getDdPrice());
					vs.setValue("#session.map", map);
				}
			}
		}
	}

	@Override
	public void cartRecov(String id) {
		ValueStack vs = ActionContext.getContext().getValueStack();
		Map<String, CartItem> recmapp = (Map<String, CartItem>) vs.findValue("#session.recmap");
		Map<String, CartItem> map = (Map<String, CartItem>) vs.findValue("#session.map");
		if(recmapp!=null){
			CartItem cartItem = recmapp.get(id);
			Integer count = (Integer) vs.findValue("#session.reccount");
			cartItem.setCount(count);
			//System.out.println(cartItem.getCount()+"//////////////////////////");
			recmapp.remove(id);
			vs.setValue("#session.recmap", recmapp);
			map.put(id, cartItem);
			vs.setValue("#session.map", map);
			//System.out.println(cartItem.getDdPrice()+"--------"+cartItem.getCount());
			//System.out.println(cartItem.getPrice()-cartItem.getDdPrice()+"+++++++"+cartItem.getCount());
			
			Double totalProductDdPrice = (Double) vs.findValue("#session.totalProductDdPrice");
			Double totalProductSavePrice = (Double) vs.findValue("#session.totalProductSavePrice");
			
			vs.setValue("#session.totalProductDdPrice", cartItem.getDdPrice()+totalProductDdPrice);//所有商品累计当当价
			vs.setValue("#session.totalProductSavePrice", totalProductSavePrice+(cartItem.getPrice()-cartItem.getDdPrice()));//所有商品累计省钱多少
		}
		
		
	}
	
	
	
	
}
