package servlet;

import bean.Message;
import bean.User;
import dao.MessageDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 登录servlet
 * Created by 黄桂道 on 2017-1-14.
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String userPassword = request.getParameter("userPassword");
        UserDao userDao = new UserDao();
        User user = userDao.getUser(username, userPassword);
        if (user.getUserName()!=null) {
            MessageDao messageDao = new MessageDao();
            List<Message> list = messageDao.getMessage();
            request.getSession().setAttribute("messageList",list);
            request.getSession().setAttribute("user", user);
           request.getRequestDispatcher("/message.jsp").forward(request, response);
        }else {
            response.sendRedirect("/index.jsp?do=register");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
