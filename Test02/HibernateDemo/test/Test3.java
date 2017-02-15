import entity.Commodity;
import entity.Customer;
import entity.Orderform;
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
public class Test3 {

    private Session session = null;

    @Before
    public void setUp() throws Exception {
        session = HibernateSessionFactory.getSession();

    }

    @After
    public void tearDown() throws Exception {

        session.close();
    }

    @Test
    public void getIn(){
        String hql = "from Commodity c where c.price  in(30,4000)";
        Query query = session.createQuery(hql);
        List<Commodity> list = query.list();
        for (Commodity l : list) {
            System.out.print("name:"+l.getName());
            System.out.println("price:"+l.getPrice());
        }
    }
    @Test
    public void get2(){
        String hql = "from Customer c where c.address<>null ";
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();
        for (Customer l : list) {
            System.out.print("name:"+l.getName());
            System.out.println(" address:"+l.getAddress());
        }
    }


    @Test
    public void getLike(){
        String hql = "from Commodity c where c.category  like '电%' and c.price>400";
        Query query = session.createQuery(hql);
        List<Commodity> list = query.list();
        for (Commodity l : list) {
            System.out.print("name:"+l.getName());
            System.out.print(" price:"+l.getPrice());
            System.out.println("category:"+l.getCategory());
        }
    }
    @Test
    public void getIs(){
        String hql = "from Orderform o where o.orderitems is not empty ";
        Query query = session.createQuery(hql);
        List<Orderform> list = query.list();
        for (Orderform l : list) {
            System.out.print("name:"+l.getId());
            System.out.print(" price:"+l.getCustomer().getName());
            System.out.println(" category:"+l.getTradedate());
        }
    }

    @Test
    public void getSi(){
        String hql = "from Commodity c where c.price*5>900 ";
        Query query = session.createQuery(hql);
        List<Commodity> list = query.list();
        for (Commodity l : list) {
            System.out.print("name:"+l.getName());
            System.out.println(" price:"+l.getPrice());
        }
    }
    @Test
    public void getOrder(){
        String hql = "from Commodity c order by c.price desc,c.id ";
        Query query = session.createQuery(hql);
        List<Commodity> list = query.list();
        for (Commodity l : list) {
            System.out.print("name:"+l.getName());
            System.out.print(" id:"+l.getId());
            System.out.println(" price:"+l.getPrice());
        }
    }

    @Test
    public void getTest(){
        String hql = "select new list (c.name,c.price,c.seller.name,c.seller.business) " +
                " from Commodity c where c.seller.business like '%书%' and c.price >10" +
                " order by c.seller.name desc ,c.price asc ,c.name asc ";
        Query query = session.createQuery(hql);
        List<List> lists = query.list();
        for (List l : lists) {
            System.out.print("name:"+l.get(0));
            System.out.print(" price:"+l.get(1));
            System.out.print(" sellerName:"+l.get(2));
            System.out.println(" sellerBusiness:"+l.get(3));
        }
    }
    @Test
    public void getTest2(){
        String hql = "select new list (o.customer.name,o.tradedate,o.status,o.amount) " +
                " from Orderform o where (o.tradedate >='2015-05-01' and o.tradedate<='2015-06-01') " +
                " and (o.status = '已发货' or o.status='已付款') and o.amount>1000 " +
                "order by o.status asc ,o.tradedate desc ,o.amount desc ";
        Query query = session.createQuery(hql);
        List<List> lists = query.list();
        for (List l : lists) {
            System.out.print("customerName:"+l.get(0));
            System.out.print(" tradedate:"+l.get(1));
            System.out.print(" status:"+l.get(2));
            System.out.println(" amount:"+l.get(3));
        }
    }
}
