package NoUseBackup;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dangdang.entity.Duser;
import com.baizhi.dangdang.user.service.DuserService;
import com.baizhi.dangdang.user.serviceImpl.DuserServiceImpl;
import com.baizhi.dangdang.util.Md5Util;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginAnsynAction implements Action{
	private Duser duser;
	public Duser getDuser() {
		return duser;
	}
	public void setDuser(Duser duser) {
		this.duser = duser;
	}
	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ValueStack vs = ActionContext.getContext().getValueStack();
		DuserService service = new DuserServiceImpl();
		Duser user = service.findOneDuser(duser.getEmail());
		if(user == null){
			out.println("email不存在,请注册");
			return null;
		}
		boolean flag = Md5Util.checkPassword(duser.getPassword()+user.getSalt(), user.getPassword());
		if(flag == true)
			duser = user;
		else
			duser = null;
		if(duser==null){
			out.println("email地址或密码错误");
			return null;
		}else if(duser.getStatus() == 0){
			out.println("账户未激活,点击激活");
			return null;
		}else{
			out.println("");
			return null;
		}
	}

}
