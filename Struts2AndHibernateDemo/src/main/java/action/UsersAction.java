package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.Users;
import org.apache.struts2.interceptor.validation.SkipValidation;
import service.UsersDao;
import serviceImpl.UsersDaoImpl;

import java.text.ParseException;
import java.util.List;

/**
 * 用户Action动作类
 * Created by 黄桂道 on 2017-1-24.
 */
public class UsersAction extends SuperAction implements ModelDriven<Users> {

    private static final long serialVersionUID = 4317500994450323565L;
    private Users user = new Users();

    public Users getModel() {
        return this.user;
    }

    //用户登录动作
    public String login() {
        UsersDao udao = new UsersDaoImpl();
        if (udao.usersLogin(user)) {
            //在session中保存用户名
            session.setAttribute("loginUserName",user.getUsername());
            return "login_success";
        } else {
            this.addFieldError("loginError","用户名或密码不正确！");
            return "login_failure";
        }
    }

    @SkipValidation
    //用户退出登录动作,不用表单验证
    public String logout() {
        if (session.getAttribute("loginUserName")!=null) {
            //在session中保存用户名
            session.removeAttribute("loginUserName");
            session.removeAttribute("users_list");
            session.removeAttribute("get_user");
        }
        return "logout_success";
    }

    @SkipValidation
    //查询所有用户资料
    public String queryAllUsers() {
        UsersDao udao = new UsersDaoImpl();
        List<Users> list = udao.queryAllUsers();
        if (list != null && list.size() > 0) {
            session.setAttribute("users_list", list);
        }
        return "user_query_all_success";
    }

    @SkipValidation
    //根据用户编号查询单个用户资料
    public String getUser() {
        UsersDao udao = new UsersDaoImpl();
        Users user = udao.queryUserById(Integer.parseInt(request.getParameter("uid")));
        //保存在会话中
        session.setAttribute("get_user",user);
        return "get_user_success";
    }

    @SkipValidation
    //添加用户
    public String addUser() throws ParseException {
        UsersDao udao = new UsersDaoImpl();
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        Users user = new Users(uname,password);
        udao.addUser(user);
        return "add_succeed";

    }

    @SkipValidation
    //修改用户资料
    public String update() throws ParseException {
        UsersDao udao = new UsersDaoImpl();
        int uid = ((Users) session.getAttribute("get_user")).getUid();
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        Users user = new Users(uid,uname,password);
        udao.updateUser(user);
        return "update_success";
    }

    @SkipValidation
    //删除用户
    public String delete() {
        UsersDao udao = new UsersDaoImpl();
        int uid = Integer.parseInt(request.getParameter("uid"));
        udao.deleteUser(uid);
        return "delete_success";
    }


    //表单验证

    @Override
    public void validate() {
        //用户名不能为空
        if ("".equals(user.getUsername().trim())){
            this.addFieldError("usernameError","用户名不能为空!");
        }
        //密码不能为空
        if ("".equals(user.getPassword().trim())){
            this.addFieldError("passwordError","密码不能为空!");
        }
    }
}
