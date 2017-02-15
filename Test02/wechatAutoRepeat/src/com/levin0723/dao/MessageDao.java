package com.levin0723.dao;

import com.levin0723.bean.Message;
import com.levin0723.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * message数据库操作
 * Created by 黄桂道 on 2017-2-13.
 */
public class MessageDao {

    //根据条件查询  通过Mybatis的方式
    public List<Message> queryList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<Message>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            messageList = sqlSession.selectList("Message.queryList",message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }

    //根据ID条件删除单条记录  通过Mybatis的方式
    public void deleteOne(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //根据list<ID>条件删除多条记录  通过Mybatis的方式
    public void deleteBatch(List<Integer> ids) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }





   /* //根据条件查询  通过JDBC的方式
    public List<Message> queryList(String command,String description){
        //JDBC转接数据库
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","daodao");
            StringBuilder sql = new StringBuilder(" SELECT ID,COMMAND,DESCRIPTION,CONTENT FROM test.message WHERE 1=1 ");
            if (command !=null&&!"".equals(command.trim())){
                command = " AND COMMAND='"+command+"'";
                sql.append(command);
            }
            if (description !=null&&!"".equals(description.trim())){
                description = "AND DESCRIPTION like '%"+description+"%'";
                sql.append(description);
            }
            PreparedStatement statement = conn.prepareStatement(sql.toString());
            ResultSet rs = statement.executeQuery();
            List<Message> messageList = new ArrayList<Message>();
            while (rs.next()){
                Message message = new Message();
                message.setId(rs.getString("ID"));
                message.setCommand(rs.getString("COMMAND"));
                message.setDescription(rs.getString("DESCRIPTION"));
                message.setContent(rs.getString("CONTENT"));
                messageList.add(message);
            }
            return messageList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
