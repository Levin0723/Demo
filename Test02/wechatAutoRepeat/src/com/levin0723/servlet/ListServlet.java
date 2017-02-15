package com.levin0723.servlet;

import com.levin0723.bean.Command;
import com.levin0723.bean.Page;
import com.levin0723.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 列表页面控制
 * Created by 黄桂道 on 2017-2-13.
 */
@WebServlet(name = "ListServlet", urlPatterns = "/List.action")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 9212185910486803440L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //从页面取值
        String command = request.getParameter("command");
        String description = request.getParameter("description");
        //向页面传值
        request.setAttribute("name", command);
        request.setAttribute("description", description);

        //分布
        String currentPage = request.getParameter("currentPage");
        Page page = new Page();
        Pattern pattern = Pattern.compile("[0-9]{1,9}");
        if (currentPage==null||!pattern.matcher(currentPage).matches()){
            page.setCurrentPage(1);
        }else {
            page.setCurrentPage(Integer.valueOf(currentPage));
        }
        QueryService service = new QueryService();
        List<Command> messageList = service.getList(command,description,page);
        request.setAttribute("messageList", messageList);
        request.setAttribute("page", page);
        //页面跳转
        request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
