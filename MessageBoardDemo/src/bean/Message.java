package bean;

import java.io.Serializable;

/**
 * 留言类
 * Created by 黄桂道 on 2017-1-14.
 */
public class Message implements Serializable{

    private static final long serialVersionUID = -2038909307851648832L;
    private int messageId;
    private User user;
    private String messageContent;
    private String messageTime;

    public Message() {
        super();
    }

    public Message(User user, String messageContent, String messageTime) {
        this.user = user;
        this.messageContent = messageContent;
        this.messageTime = messageTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

}
