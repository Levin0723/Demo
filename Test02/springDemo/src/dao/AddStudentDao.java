package dao;

import bean.Student;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AddStudentDao extends JdbcDaoSupport {
    public void addStudent(Student student){
        String sql = "INSERT INTO student VALUES ('"+student.getName()+"','"+student.getAge()+"','"+student.getGender()+"')";
        getJdbcTemplate().execute(sql);
    }
}
