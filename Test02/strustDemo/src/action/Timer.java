package action;

import com.opensymphony.xwork2.ActionSupport;

public class Timer extends ActionSupport {
    @Override
    public String execute() throws Exception {
        for (int i = 1; i <= 10000; i++) {
            System.out.println("这是第"+i+"次测试！");
        }
        return SUCCESS;
    }
}
