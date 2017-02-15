package intercept;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //1.执行Action之前的时间
        long start = System.currentTimeMillis();
        //2.执行下一个拦截器，如果已经是最后一个拦截器，则执行Action
        String result = actionInvocation.invoke();//表示调用下一个拦截器或Action
        //3.执行Action完之后的时间
        long end = System.currentTimeMillis();
        System.out.println("执行Action所花费的时间："+(end-start));
        return result;
    }
}
