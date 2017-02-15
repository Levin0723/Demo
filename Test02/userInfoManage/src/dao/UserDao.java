package dao;

import entity.Info;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;

import java.util.Iterator;
import java.util.List;

/**
 * 用户操作类
 * Created by 黄桂道 on 2017-1-21.
 */
public class UserDao {
    private static Session session = null;
    private static Query query = null;
    private static Transaction transaction = null;

    //分页显示用户信息
    public static List findByPage(int pageNo, int pageSize){
        session = HibernateSessionFactory.getSession();
        transaction = session.beginTransaction();
        String hql = "from Info info";
        query = session.createQuery(hql);
        query.setFirstResult((pageNo-1)*pageSize); //设置从哪一行记录开始
        query.setMaxResults(pageSize); //设置读取多少个记录
        return  query.list();
    }

    //获取用户总数
    public static int getCount(){
        Long count = null;
        session = HibernateSessionFactory.getSession();
        transaction = session.beginTransaction();
        String hql = "select count(info.id) from Info info";
        query = session.createQuery(hql);
        List list = query.list();
        Iterator iterator = list.iterator();
        if (iterator.hasNext()){
            count = (Long) iterator.next();
        }
        session.close();
        return count.intValue();
    }

    //更新用户信息
    public static void updateInfo(Info info){
        session = HibernateSessionFactory.getSession();
        transaction = session.beginTransaction();
        session.update(info);
        transaction.commit();
        session.close();
    }

    //删除用户信息
    public static void deleteInfo(int id){
        session = HibernateSessionFactory.getSession();
        transaction = session.beginTransaction();
        Info info = session.load(Info.class, id);
        session.delete(info);
        transaction.commit();
        session.close();
    }

    //添加用户信息
    public static void addInfo(Info info){
        session = HibernateSessionFactory.getSession();
        transaction = session.beginTransaction();
        session.save(info);
        transaction.commit();
        session.close();
    }

    //根据ID查用户信息
    public static Info getInfoById(int id){
        session = HibernateSessionFactory.getSession();
        transaction = session.beginTransaction();
        Info info = session.get(Info.class, id);
        transaction.commit();
        session.close();
        return info;
    }
}
