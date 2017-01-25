package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 所有Action动作的父类
 * Created by 黄桂道 on 2017-1-24.
 */

//方法一
//public class SuperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
//
//    protected HttpServletRequest request;    //请求对象
//    protected HttpServletResponse response;  //响应对象
//    protected ServletContext application;    //全局对象
//    protected HttpSession session;           //会话对象
//
//    public void setServletRequest(HttpServletRequest request) {
//        this.request = request;
//        this.session = request.getSession();
//    }
//
//    public void setServletResponse(HttpServletResponse response) {
//        this.response = response;
//    }
//
//    public void setServletContext(ServletContext application) {
//        this.application = application;
//    }
//}

//方法二

public class SuperAction extends ActionSupport{

    private static final long serialVersionUID = 5110053493783737838L;
    protected HttpServletRequest request = ServletActionContext.getRequest();    //请求对象
    protected HttpServletResponse response = ServletActionContext.getResponse();  //响应对象
    protected ServletContext application = ServletActionContext.getServletContext();    //全局对象
    protected HttpSession session =ServletActionContext.getRequest().getSession();           //会话对象



}

