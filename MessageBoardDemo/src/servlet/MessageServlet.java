package servlet;

import bean.Message;
import bean.User;
import dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 添加留言
 * Created by 黄桂道 on 2017-1-16.
 */
@WebServlet(name = "MessageServlet",urlPatterns = {"/messageServlet"})
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String messageContent = request.getParameter("messageContent");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user = (User) request.getSession().getAttribute("user");
        Message message = new Message(user,messageContent,sdf.format(new Date()));
        MessageDao mdao = new MessageDao();
        int i = mdao.addMessage(message);
        if(i!=0){
            MessageDao messageDao = new MessageDao();
            List<Message> list = messageDao.getMessage();
            request.getSession().setAttribute("messageList",list);
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else {
            response.sendRedirect("/message.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
