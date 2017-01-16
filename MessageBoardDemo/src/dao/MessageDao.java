package dao;

import Util.DBHelper;
import bean.Message;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Message操作类
 * Created by 黄桂道 on 2017-1-14.
 */
public class MessageDao {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;


    //添加留言方法
    public int addMessage(Message message) {
        int i = 0;
        conn = DBHelper.getConnection();
        String sql = "INSERT INTO message_info(userId,messageContent,messageTime) " +
                "VALUES (?,?,?); ";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, message.getUser().getUserId());
            pstm.setString(2, message.getMessageContent());
            pstm.setString(3, message.getMessageTime());
            i = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    //取得所有留言方法
    public List<Message> getMessage(){
        List<Message> list = new ArrayList<Message>();
        conn = DBHelper.getConnection();
        String sql = "SELECT * FROM message_info,user_info WHERE " +
                "message_info.userId = user_info.userId ; ";
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                Message m = new Message();
                m.setMessageContent(rs.getString("messageContent"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                m.setMessageTime(sdf.format(rs.getTimestamp("messageTime")));
                m.setMessageId(rs.getInt("messageId"));
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                m.setUser(user);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
