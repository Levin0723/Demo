package action;

import entity.Students;
import serviceImpl.StudentsDaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 学生动作类
 * Created by 黄桂道 on 2017-1-24.
 */
public class StudentsAction extends SuperAction {

    private static final long serialVersionUID = 7524786985348374469L;

    //查询所有学生资料
    public String queryAllStudnets() {
        StudentsDaoImpl udao = new StudentsDaoImpl();
        List<Students> list = udao.queryAllStudents();
        if (list != null && list.size() > 0) {
            session.setAttribute("students_list", list);
        }
        return "student_query_all_success";
    }

    //根据学生编号查询单个学生资料
    public String getStudent() {
        StudentsDaoImpl udao = new StudentsDaoImpl();
        Students student = udao.queryStudentById(request.getParameter("sid"));
        //保存在会话中
        session.setAttribute("get_student",student);
        return "get_student_success";
    }

    //添加学生
    public String addStudent() throws ParseException {
        StudentsDaoImpl udao = new StudentsDaoImpl();
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bir = sdf.parse(birthday);
        String address = request.getParameter("address");
        Students student = new Students(sid, sname, gender, bir, address);
        udao.addStudent(student);
        return "add_succeed";

    }

    //修改学生资料
    public String update() throws ParseException {
        StudentsDaoImpl udao = new StudentsDaoImpl();
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bir = sdf.parse(birthday);
        String address = request.getParameter("address");
        Students student = new Students(sid, sname, gender, bir, address);
        udao.updateStudent(student);
        return "update_success";
    }

    //删除学生
    public String delete() {
        StudentsDaoImpl udao = new StudentsDaoImpl();
        String sid = request.getParameter("sid");
        udao.deleteStudent(sid);
        return "delete_success";
    }
}
