package com.ruolan.cainiaomes.entity;

import java.io.Serializable;

/**
 * Created by wuyinlei on 2016/10/29.
 */

public class Message implements Serializable{

    public enum StatusType{ing,done,fail};
    public enum MessageType{plain,audio,image,location,emo};


    private String id;
    private String senderId;
    private String reeiverId;
    private MessageType type;
    private String content;
    private Attachment attachment;
    private StatusType statue;
    private long timestamp;
    private boolean isRead;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReeiverId() {
        return reeiverId;
    }

    public void setReeiverId(String reeiverId) {
        this.reeiverId = reeiverId;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public StatusType getStatue() {
        return statue;
    }

    public void setStatue(StatusType statue) {
        this.statue = statue;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
