import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService dao = context.getBean("accountService",AccountService.class);
        dao.transfer("aaa","ccc",200d);
    }

    @org.junit.Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        declarative.transaction.com.AccountService dao = context.getBean("accountServiceProxy",declarative.transaction.com.AccountService.class);
        dao.transfer("ccc","aaa",200d);
    }
}
