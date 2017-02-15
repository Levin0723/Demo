import bean.ShowStudent;
import bean.Student;
import dao.AddStudentDao;
import dao.StudentDao;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import pointcut.People;

import java.util.List;
import java.util.Map;

public class Test01 {

    @org.junit.Test
    public void test() throws Exception {
        //加载配置文件
        Resource resouce = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resouce);
        //获取bean
        Student student = (Student) factory.getBean("student");
        student.setName("张三");
        student.setAge(23);
        student.setGender("男");
        System.out.println(student.toString());


    }

    @Test
    public void test2() throws Exception {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        Student student = (Student) context.getBean("student");
        student.setName("张三");
        student.setAge(23);
        student.setGender("男");
        System.out.println(student.toString());


    }

    @Test
    public void test3() throws Exception {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //获取bean
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());

    }

    @Test
    public void test4() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ShowStudent show = (ShowStudent) context.getBean("show");
        show.show();

    }

    @Test
    public void test5() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = (People) context.getBean("proxyFactoryBean");
        people.speaking();
        people.runing();
        people.loving();
        people.died();

    }

    @Test
    public void test6() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Student student = new Student("王五",26,"男");
        Student student2 = new Student("周七",20,"女");
        StudentDao sDao = (StudentDao) context.getBean("studentDao");
        int result = sDao.addStudent(student2);
        System.out.println(result);
    }

    @Test
    public void test7() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Student student = new Student("张三",22,"男");
        AddStudentDao add = (AddStudentDao) context.getBean("transcationProxy");
        add.addStudent(student);
    }

    @Test
    public void test8() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "INSERT INTO student VALUES ('李四',29,'女')";
        int result = -1;
        result = jdbcTemplate.update(sql);
        System.out.println(result);
    }

    @Test
    public void test9() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "SELECT * FROM test.student ";
        List<Map<String, Object>> lists = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> m : lists) {
            System.out.println(m.get("name")+" "+m.get("age")+" "+m.get("gender"));
        }
    }
}
