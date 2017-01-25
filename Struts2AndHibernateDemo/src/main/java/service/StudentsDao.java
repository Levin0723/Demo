package service;

import entity.Students;

import java.util.List;

/**
 * 学生逻辑操作接口
 * Created by 黄桂道 on 2017-1-24.
 */
public interface StudentsDao {

    //查询所有学生资料
    List<Students> queryAllStudents();

    //根据学生编号查询单个学生资料
    Students queryStudentById(String sid);

    //添加学生
    boolean addStudent(Students s);

    //修改学生资料
    boolean updateStudent(Students s);

    //删除学生
    boolean deleteStudent(String sid);
}
