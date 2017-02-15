package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * Created by 黄桂道 on 2017-1-22.
 */
public class MyAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("Hello Word");
        return SUCCESS;
    }
}
