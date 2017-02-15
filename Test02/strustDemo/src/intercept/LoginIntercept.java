package intercept;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import entity.User;

import java.util.Map;

public class LoginIntercept extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        User user = (User) session.get("user");
        if (user!=null){
            String result = actionInvocation.invoke();
            return result;
        }else {
            return "login";
        }
    }
}
