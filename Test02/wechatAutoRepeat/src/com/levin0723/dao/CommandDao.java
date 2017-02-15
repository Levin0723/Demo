package com.levin0723.dao;

import com.levin0723.bean.Command;
import com.levin0723.bean.Page;
import com.levin0723.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandDao {


    //根据条件查询  通过Mybatis的方式,并分布显示
    public List<Command> queryCommandList(String name, String description, Page page) {
        DBAccess dbAccess = new DBAccess();
        List<Command> commandList = new ArrayList<Command>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Command Command = new Command();
            Command.setName(name);
            Command.setDescription(description);
            Map<String,Object> parameter = new HashMap<String,Object>();
            parameter.put("command",Command);
            parameter.put("page",page);
            commandList = sqlSession.selectList("Command.queryCommandList",parameter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return commandList;
    }

    //根据条件查询  通过Mybatis的方式
    public List<Command> queryList(String name, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Command> commandList = new ArrayList<Command>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Command Command = new Command();
            Command.setName(name);
            Command.setDescription(description);
            commandList = sqlSession.selectList("Command.queryList",Command);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return commandList;
    }


    //根据ID条件删除单条记录  通过Mybatis的方式
    public void deleteOne(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Command.deleteOne",id);
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
            sqlSession.delete("Command.deleteBatch",ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    //查询总指令数
    public int count(String name, String description) {
        DBAccess dbAccess = new DBAccess();
        int count = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Command Command = new Command();
            Command.setName(name);
            Command.setDescription(description);
            count = sqlSession.selectOne("Command.count",Command);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return count;
    }


}
