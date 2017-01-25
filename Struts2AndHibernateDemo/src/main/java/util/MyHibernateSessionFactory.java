package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateSessionFactory工具类
 * Created by 黄桂道 on 2017-1-20.
 */
public class MyHibernateSessionFactory {
    private static SessionFactory mySessionFactory;

    //私有化构造方法，保证单例化模式
    private MyHibernateSessionFactory() {
    }

    //公有方法，获取公话工厂对象
    public static SessionFactory getSessionFactory() {
        if (mySessionFactory == null) {
            Configuration configuration = new Configuration().configure();

            mySessionFactory = configuration.buildSessionFactory();
            return mySessionFactory;
        } else {
            return mySessionFactory;
        }
    }

}