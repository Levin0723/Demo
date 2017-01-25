package serviceImpl;

import entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.UsersDao;
import util.MyHibernateSessionFactory;

import java.util.List;

/**
 *用户逻辑实现类
 * Created by 黄桂道 on 2017-1-23.
 */
public class UsersDaoImpl implements UsersDao {

    //用户登录实现方法
    public boolean usersLogin(Users user) {

        //事务对象
        Transaction tx = null;
        String hql = "";

        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            hql = "from Users where username=? and password=? ";
            Query query = session.createQuery(hql);
            query.setParameter(0,user.getUsername());
            query.setParameter(1,user.getPassword());
            List lists = query.list();
            tx.commit();
            return lists.size() > 0;

        }catch (Exception ex){
            return false;
        }finally {
                tx = null;
        }
    }

    //查询所有用户资料
    public List<Users> queryAllUsers() {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        String hql = "select new Users (uid,username,password) from Users ";
        Query query = session.createQuery(hql);
        List<Users> list = query.list();
        ts.commit();
        return list;
    }

    //根据用户编号查询单个学生资料
    public Users queryUserById(int uid) {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        Users user = session.get(Users.class,uid);
        ts.commit();
        return user;
    }

    //添加用户
    public boolean addUser(Users u) {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        session.save(u);
        ts.commit();
        return true;
    }

    //修改用户资料
    public boolean updateUser(Users u) {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        session.update(u);
        ts.commit();
        return true;
    }

    //删除用户
    public boolean deleteUser(int uid) {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        Users user = session.get(Users.class,uid);
        session.delete(user);
        ts.commit();
        return true;
    }

}
