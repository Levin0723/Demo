package utile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *HibernateSessionFactory工具类
 * Created by 黄桂道 on 2017-1-20.
 */
public class HibernateSessionFactory {
    private static final ThreadLocal<Session> THREAD_LOCAL = new ThreadLocal<Session>();
    private static  SessionFactory ourSessionFactory = null;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("创建SessionFactory失败！");
            e.printStackTrace();
        }
    }

    public static Session getSession(){
        Session session = (Session) THREAD_LOCAL.get();
        if (session == null||!session.isOpen()){
            rebuildSessionFactory();
        }
        session = (ourSessionFactory!=null)?ourSessionFactory.openSession():null;
        THREAD_LOCAL.set(session);
        return session;
    }

    public static void rebuildSessionFactory(){
        try {
            Configuration cfg = new Configuration().configure();
            ourSessionFactory = cfg.buildSessionFactory();
        }catch (Exception e){
            System.out.println("创建SessionFactory失败！");
            e.printStackTrace();
        }

    }

    public static SessionFactory getSessionFactory(){
        return ourSessionFactory;
    }

    public static void closeSession(){
        Session session = (Session)THREAD_LOCAL.get();
        THREAD_LOCAL.set(null);
        if (session != null){
            session.close();
        }
    }
}