package com.levin0723.servlet;

import com.levin0723.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by 黄桂道 on 2017-2-13.
 */
@WebServlet(name = "DeleteBatchServlet",urlPatterns = "/deleteBatch.action")
public class DeleteBatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //从页面取值
        String[] ids = request.getParameterValues("ids");

        MaintainService mService = new MaintainService();
        mService.deleteBatch(ids);
        //页面跳转
        request.getRequestDispatcher("List.action").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
