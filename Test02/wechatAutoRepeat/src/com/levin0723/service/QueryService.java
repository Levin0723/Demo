package com.levin0723.service;

import com.levin0723.bean.Command;
import com.levin0723.bean.Command_content;
import com.levin0723.bean.Page;
import com.levin0723.dao.CommandDao;

import java.util.List;
import java.util.Random;

public class QueryService {


    //根据条件查询  通过Mybatis的方式,并分布显示
    public List<Command> getList(String name, String description, Page page) {
        CommandDao commandDao = new CommandDao();
        int totalNumber = commandDao.count(name,description);
        page.setTotalNumber(totalNumber);
        List<Command> commandList = commandDao.queryCommandList(name, description,page);
        return commandList;
    }

    public String queryByCommand(String name) {
        CommandDao commandDao = new CommandDao();
        List<Command> commandList = null;
        if (name.equals("帮助")) {
            commandList = commandDao.queryList(null, null);
            StringBuilder result = new StringBuilder();
            for (Command command : commandList) {
                result.append("回复【" + command.getName() + "】可查看->" + command.getDescription());
                result.append("<br/>");
            }
            return result.toString();
        }
        commandList = commandDao.queryList(name, null);
        if (commandList.size() > 0) {
            List<Command_content> contentListlist = commandList.get(0).getContentList();
            int i = new Random().nextInt(contentListlist.size());
            return contentListlist.get(i).getContent();
        }
        return "客官，你没按套路出牌。。。我听不懂你说什么！";
    }

/*
    public List<Message> getList(String command, String description) {
        MessageDao mdao = new MessageDao();
        List<Message> messageList = mdao.queryList(command, description);
        return messageList;
    }

    public String queryByCommand(String command){
        MessageDao messageDao = new MessageDao();
        List<Message> messageList =null;
        if (command.equals("帮助")){
            messageList = messageDao.queryList(null,null);
            StringBuilder result = new StringBuilder();
            for (Message message : messageList) {
                result.append("回复【"+message.getCommand()+"】可查看->"+message.getDescription());
                result.append("<br/>");
            }
            return result.toString();
        }
        messageList = messageDao.queryList(command,null);
        if (messageList.size()>0){
            return messageList.get(0).getContent();
        }
        return "客官，你没按套路出牌。。。我听不懂你说什么！";
    }*/
}
