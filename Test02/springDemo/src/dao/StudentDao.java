package dao;

import bean.Student;

import java.sql.SQLException;
public interface StudentDao {
    public int addStudent(Student student) throws SQLException;
}
