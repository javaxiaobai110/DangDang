package NoUseBackup;

import java.util.List;


import com.baizhi.dangdang.category.service.CategoryService;
import com.baizhi.dangdang.category.serviceImpl.CategoryServiceImpl;
import com.baizhi.dangdang.entity.Category;
import com.baizhi.dangdang.product.service.ProductService;
import com.baizhi.dangdang.product.serviceImpl.ProductServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ShowAllSecondAction implements Action{
	private String categoryId;
	private Category cat;
	
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(categoryId+"------");
		CategoryService service = new CategoryServiceImpl();
		cat = service.getByCategoryId(categoryId);
		ProductService pservice = new ProductServiceImpl();
		System.out.println(cat);
		return SUCCESS;
	}

}
