package com.levin0723.service;

import com.levin0723.dao.CommandDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护Service
 * Created by 黄桂道 on 2017-2-13.
 */
public class MaintainService {
    //根据ID条件删除单条记录  通过Mybatis的方式
    public void deleteOne(String id) {
        if (id!=null&&!"".equals(id.trim())){
            CommandDao cDao = new CommandDao();
            cDao.deleteOne(Integer.valueOf(id));
        }
    }

    //根据list<ID>条件删除多条记录  通过Mybatis的方式
    public void deleteBatch(String[] ids) {
        CommandDao cDao = new CommandDao();
        List<Integer> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(Integer.valueOf(id));
        }
        cDao.deleteBatch(idList);
    }


/*    //根据ID条件删除单条记录  通过Mybatis的方式
    public void deleteOne(String id) {
        if (id!=null&&!"".equals(id.trim())){
            MessageDao mDao = new MessageDao();
            mDao.deleteOne(Integer.valueOf(id));
        }
    }

    //根据list<ID>条件删除多条记录  通过Mybatis的方式
    public void deleteBatch(String[] ids) {
        MessageDao mDao = new MessageDao();
        List<Integer> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(Integer.valueOf(id));
        }
        mDao.deleteBatch(idList);
    }*/
}
