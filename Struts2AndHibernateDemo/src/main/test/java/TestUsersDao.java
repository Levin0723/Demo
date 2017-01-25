import entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import serviceImpl.UsersDaoImpl;
import util.MyHibernateSessionFactory;

import java.util.List;

/**
 *
 * Created by 黄桂道 on 2017-1-23.
 */
public class TestUsersDao {
    @Test
    public void usersLogin() throws Exception {
        Users user = new Users(1,"zhangsan","123456");
        UsersDaoImpl udao = new UsersDaoImpl();
        System.out.println(udao.usersLogin(user));
    }

    @Test
    public void check(){
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        String hql = "from Users ";
        Query query = session.createQuery(hql);
        List<Users> list = query.list();
        for (Users user : list) {
            System.out.println(user.toString());
        }
    }
}
