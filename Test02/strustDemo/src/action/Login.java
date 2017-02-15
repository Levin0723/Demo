package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.User;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class Login extends ActionSupport implements ModelDriven<User>, SessionAware {

    private static final long serialVersionUID = -3218845361036911352L;
    //    private User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
    //使用ModelDriven方法获取参数 需要实例化对象 new 一个对象
    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Map<String, Object> session;

    public String login() {
        if ("admin".equals(user.getUsername()) && "12345".equals(user.getPassword())) {
            session.put("user", user);
            return SUCCESS;
        } else {
            session.put("loginError","用户名或密码不正确！");
            return ERROR;
        }
    }

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

//    @Override
//    public void validate() {
//        if (user.getUsername()==null||"".equals(user.getUsername())){
//            this.addFieldError("username","用户名不能为空！");
//           // this.addActionMessage("用户名不能为空！");
//
//        }
//        if (user.getPassword() == null || "".equals(user.getPassword() )) {
//           this.addFieldError("username", "密码不能为空！");
//           // this.addActionMessage("密码不能为空！");
//
//        }
//    }
}
