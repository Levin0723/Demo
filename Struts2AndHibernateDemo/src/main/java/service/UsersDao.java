package service;

import entity.Users;

import java.util.List;

/**
 * 用户逻辑接口
 * Created by 黄桂道 on 2017-1-23.
 */
public interface UsersDao {

    //用户登录方法
    boolean usersLogin(Users user);


    //查询所有用户资料
    List<Users> queryAllUsers();

    //根据用户编号查询单个学生资料
    Users queryUserById(int uid);

    //添加用户
    boolean addUser(Users u);

    //修改用户资料
    boolean updateUser(Users u);

    //删除用户
    boolean deleteUser(int uid);
}
