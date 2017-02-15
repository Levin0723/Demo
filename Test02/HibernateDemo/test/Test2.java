import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utile.HibernateSessionFactory;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by 黄桂道 on 2017-1-21.
 */
public class Test2 {

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
    public void getForObjectArry(){
        String hql = "select s.name,s.tel,s.address,s.star from Seller as s ";
        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        for (Object[] obj : list) {
            System.out.print("name:"+obj[0]);
            System.out.print(" tel:"+obj[1]);
            System.out.print(" address:"+obj[2]);
            System.out.println(" star:"+obj[3]);
        }
    }
    @Test
    public void getForObject(){
        String hql = "select s.name from Seller as s ";
        Query query = session.createQuery(hql);
        List<Object> lists = query.list();
        for (Object obj : lists) {
            System.out.print(" name:"+obj);
        }
    }

    @Test
    public void getForList(){
        String hql = "select new list (s.name,s.tel,s.address,s.star) from Seller as s ";
        Query query = session.createQuery(hql);
        List<List> lists = query.list();
        for (List list : lists) {
            System.out.print("name:"+list.get(0));
            System.out.print(" tel:"+list.get(1));
            System.out.print(" address:"+list.get(2));
            System.out.println(" star:"+list.get(3));
        }
    }
    @Test
    public void getForMap(){
       // String hql = "select new map (s.name,s.tel,s.address,s.star) from Seller as s ";
        String hql = "select new map (s.name as name,s.tel as tel,s.address as address,s.star as star) from Seller as s ";
        Query query = session.createQuery(hql);
        List<Map> maps = query.list();
        for (Map map : maps) {
//            System.out.print("name:"+map.get("0"));
//            System.out.print(" tel:"+map.get("1"));
//            System.out.print(" adress:"+map.get("2"));
//            System.out.println(" star:"+map.get("3"));
            System.out.print("name:" + map.get("name"));
            System.out.print(" tel:" + map.get("tel"));
            System.out.print(" address:" + map.get("address"));
            System.out.println(" star:" + map.get("star"));
        }
    }

    @Test
    public void getSexWhitDistin(){
        String hql = "select distinct c.sex from Customer as c";
        Query query = session.createQuery(hql);
        List<Object> lists = query.list();
        for (Object list : lists) {
            System.out.println(list);
        }
    }

}
