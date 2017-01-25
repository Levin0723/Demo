import entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import serviceImpl.StudentsDaoImpl;
import util.MyHibernateSessionFactory;

import java.util.Date;
import java.util.List;


/**
 * 
 * Created by 黄桂道 on 2017-1-24.
 */
public class TestStudentDao {

    @Test
    public void addStudent() throws Exception {

        SessionFactory sf = MyHibernateSessionFactory.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction ts = session.beginTransaction();
        Students s1 = new Students("1510201","张三","男",new Date(),"广州白云区");
        Students s2 = new Students("1510202","李四","女",new Date(),"广州荔湾区");
        Students s3 = new Students("1510203","王五","男",new Date(),"广州天河区");

        session.save(s1);
        session.save(s2);
        session.save(s3);

        ts.commit();
        session.close();
        sf.close();
    }

    @Test
    public void queryAllStudent() throws Exception {
        StudentsDaoImpl sdao = new StudentsDaoImpl();
        List<Students> list = sdao.queryAllStudents();
        for (Students student : list) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void get() throws Exception {

        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        String hql = "from Students ";
        Query query = session.createQuery(hql);
        List<Students> list = query.list();
        for (Students student : list) {
            System.out.println(student.toString());

        }
    }
}
