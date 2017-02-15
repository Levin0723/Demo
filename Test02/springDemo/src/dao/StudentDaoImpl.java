package dao;

import bean.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addStudent(Student student) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        conn = dataSource.getConnection();
        String sql = "INSERT INTO student VALUES (?,?,?)";
        psm = conn.prepareStatement(sql);
        psm.setString(1,student.getName());
        psm.setInt(2,student.getAge());
        psm.setString(3,student.getGender());
        int rusult = -1;
        rusult = psm.executeUpdate();
        return rusult;
    }
}
