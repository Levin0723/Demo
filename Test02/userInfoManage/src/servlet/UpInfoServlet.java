package servlet;

import dao.UserDao;
import entity.Info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by 黄桂道 on 2017-1-21.
 */
@WebServlet(name = "UpInfoServlet",urlPatterns = {"/upInfoServlet"})
public class UpInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        int id = Integer.parseInt(request.getParameter("id"));
        Info info = UserDao.getInfoById(id);
        info.setName(name);
        info.setPass(pass);
        UserDao.updateInfo(info);
        response.sendRedirect("index.jsp?action=up");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
