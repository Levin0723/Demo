package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 1
 * Created by 黄桂道 on 2017-1-8.
 */
@WebFilter(name = "Servlet", value = {"/servlet"})
public class Filter implements javax.servlet.Filter {

     private FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse) resp;

        String no = config.getInitParameter("noFiter");
        System.out.println(no);
        if (no!=null){
            String[] arr = no.split(";");
            for (String s : arr) {
                if (s==null||"".equals(s)){
                    continue;
                }
                if(request.getRequestURI().contains("s")){
                    //如果是登录页面，直接放行
                    chain.doFilter(req,resp);
                    return; //阻止继续往下执行
                }
            }
        }

        if(session.getAttribute("username")!=null){
            //如果用户名存在，允许请求
            chain.doFilter(req,resp);
        }else {
            //否则内部跳转回登录页面
            response.sendRedirect("/nologin.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
