package pointcut;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置通知
 * Created by 黄桂道 on 2017-2-2.
 */
public class PeopleBeforeAdvice  implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getSimpleName()+" is "+method.getName()+"-->");
    }
}
