import entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utile.HibernateSessionFactory;

import java.util.List;

/**
 *
 * Created by 黄桂道 on 2017-1-21.
 */
public class Test1 {

    private Session session = null;

    @Before
    public void setUp() throws Exception {
        session = HibernateSessionFactory.getSession();

    }


    @Test  //获取顾客
    public void getCustomer() throws Exception {

        String hql = "from Customer as customer";
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();
        for (Customer l : list) {

            System.out.println(l.toString());
        }
    }

    @Test  //获取商家
    public void getSeller() throws Exception {

        String hql = "from Seller ";
        Query query = session.createQuery(hql);
        List<Seller> list = query.list();
        for (Seller l : list) {

            System.out.println(l.toString());
        }
    }

    @Test  //获取商品
    public void getCommodity() throws Exception {

        String hql = "from Commodity ";
        Query query = session.createQuery(hql);
        List<Commodity> list = query.list();
        for (Commodity l : list) {
            System.out.println(l.getName());
           // System.out.println(l.toString());
            System.out.println(l.getSeller().getName());
        }
    }

    @Test  //获取订单
    public void getOrderform() throws Exception {

        String hql = "from Orderform ";
        Query query = session.createQuery(hql);
        List<Orderform> list = query.list();
        for (Orderform l : list) {

            System.out.println(l.toString());
        }
    }

    @Test  //获取订单明细
    public void getOrderitem() throws Exception {

        String hql = "from Orderitem ";
        Query query = session.createQuery(hql);
        List<Orderitem> list = query.list();
        for (Orderitem l : list) {

            System.out.println(l.toString());
        }
    }


    @After
    public void tearDown() throws Exception {

        session.close();
    }
}
