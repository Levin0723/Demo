package dao;

import Util.DBHelper;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户逻辑类
 * Created by 黄桂道 on 2017-1-14.
 */
public class UserDao {

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    //根据用户和密码来查询用户信息
    public User getUser(String name,String password){
        User user = new User();
        String sql = "SELECT * FROM user_info WHERE userName = ? " +
                "AND userPassword = ? ;";
        conn = DBHelper.getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,name);
            pstm.setString(2,password);
            rs = pstm.executeQuery();
            while (rs.next()){
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user!=null){
            return user;
        }else {
            return null;
        }
    }

    //注册用户
    public int addUser(String name,String password){
        int i = 0;
        String sql = "INSERT INTO user_info(userName,userPassword) VALUES (?,?) ;";
        conn = DBHelper.getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,name);
            pstm.setString(2,password);
            i = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
