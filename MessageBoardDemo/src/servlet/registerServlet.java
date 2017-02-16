package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册servlet
 * Created by 黄桂道 on 2017-1-14.
 */
@WebServlet(name = "registerServlet", urlPatterns = {"/register"})
public class registerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String userPassword = request.getParameter("userPassword");
        UserDao userDao = new UserDao();
        System.out.println(username+" "+userPassword);
        int i = userDao.addUser(username,userPassword);
        if(i!=0){
            response.sendRedirect("/register.jsp?result=true");
        }else {
            response.sendRedirect("/register.jsp?result=false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
