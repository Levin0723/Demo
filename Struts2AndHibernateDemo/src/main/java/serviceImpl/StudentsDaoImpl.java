package serviceImpl;

import entity.Students;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.StudentsDao;
import util.MyHibernateSessionFactory;

import java.util.List;

/**
 * 学生操作实现类
 * Created by 黄桂道 on 2017-1-24.
 */
public class StudentsDaoImpl implements StudentsDao {
    //查询所有学生资料
    public List<Students> queryAllStudents() {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        String hql = "select new Students(sid,sname,gender,birthday,address) from Students";
        Query query = session.createQuery(hql);
        List<Students> list = query.list();
        ts.commit();
        return list;
    }

    //根据学生编号查询单个学生资料
    public Students queryStudentById(String sid) {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        Students student = session.get(Students.class,sid);
        ts.commit();
        return student;
    }

    //添加学生
    public boolean addStudent(Students s) {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        session.save(s);
        ts.commit();
        return true;
    }

    //修改学生资料
    public boolean updateStudent(Students s) {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        session.update(s);
        ts.commit();
        return true;
    }

    //删除学生
    public boolean deleteStudent(String sid) {
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction ts = session.beginTransaction();
        Students s = session.get(Students.class,sid);
        session.delete(s);
        ts.commit();
        return true;
    }
}
