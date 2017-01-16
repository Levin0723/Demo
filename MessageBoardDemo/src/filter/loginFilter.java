package filter;

import bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录过滤
 * Created by 黄桂道 on 2017-1-16.
 */
@WebFilter(filterName = "loginFilter",urlPatterns = {"/message.jsp"})
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            chain.doFilter(req, resp);
        }else {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("/index.jsp?do=register");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
