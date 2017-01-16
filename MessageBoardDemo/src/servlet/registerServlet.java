package servlet;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
            request.getSession().setAttribute("user", user);
            PrintWriter out = response.getWriter();
           request.getRequestDispatcher("/message.jsp").forward(request, response);
        }else {
            PrintWriter out = response.getWriter();
            out.println("");
            response.sendRedirect("/index.jsp?do=register");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
