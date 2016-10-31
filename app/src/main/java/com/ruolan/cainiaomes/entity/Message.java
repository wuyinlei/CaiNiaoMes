package com.ruolan.cainiaomes.entity;

import com.google.gson.stream.JsonReader;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.ruolan.cainiaomes.MesApplicaption;
import com.ruolan.cainiaomes.db.ConversationController;
import com.ruolan.cainiaomes.net.AppException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by wuyinlei on 2016/10/29.
 *
 */
@DatabaseTable(tableName = "message")
public class Message extends BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String TIMESTAMP = "timestamp";
    public static final String SENDERID = "senderId";
    public static final String RECEIVERID = "receiverId";
    public static final String ISREAD = "isRead";
    public static final String _ID = "_id";
    public static final String SENDER_NAME = "sender_name";
    public static final String RECEIVER_NAME = "receiver_name";
    public static final String CONTENT_TYPE = "content_type";
    public static final String CONTENT = "content";
    public static final String STATUS = "status";
    public static final String ATTACHMENTS = "attachments";

    public enum StatusType {
        ing, done, fail
    }

    public enum MessageType {
        txt, multimedia,emo
    }

    @DatabaseField(id = true)
    private String _id;
    @DatabaseField
    private String senderId;
    @DatabaseField
    private String sender_name;
    @DatabaseField
    private String sender_picture;
    @DatabaseField
    private String receiverId;
    @DatabaseField
    private String receiver_name;
    @DatabaseField
    private String receiver_picture;
    @DatabaseField
    private MessageType content_type;
    @DatabaseField
    private String content;
    @DatabaseField(dataType= DataType.SERIALIZABLE)
    private ArrayList<Attachment> attachments;
    @DatabaseField
    private StatusType status;
    @DatabaseField
    private long timestamp;
    @DatabaseField
    private boolean isRead;
    private int percent;


    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_picture() {
        return sender_picture;
    }

    public void setSender_picture(String sender_picture) {
        this.sender_picture = sender_picture;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_picture() {
        return receiver_picture;
    }

    public void setReceiver_picture(String receiver_picture) {
        this.receiver_picture = receiver_picture;
    }

    public MessageType getType() {
        return content_type;
    }

    public void setType(MessageType type) {
        this.content_type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
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

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public MessageType getContent_type() {
        return content_type;
    }

    public void setContent_type(MessageType content_type) {
        this.content_type = content_type;
    }

    public static Message test(String id, String senderId, String receiverId) {
        Message message = new Message();
        message.set_id(id);
        message.setContent("content:" + id);
        message.setStatus(StatusType.ing);
        message.setType(MessageType.txt);
        message.setTimestamp(System.currentTimeMillis());
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        return message;
    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return hashCode() == o.hashCode();
    }

    @Override
    public String toString() {
        return timestamp + "---"+sender_name + " send " + content + " to " + receiver_name + " " + status;
    }

    public Conversation copyTo() {
        Conversation conversation = new Conversation();
        conversation.setContent(getContent());
        conversation.setStatus(getStatus());
        conversation.setTimestamp(getTimestamp());
        conversation.setType(getType());
        if (!getSenderId().equals(MesApplicaption.selfId)) {
            conversation.setTargetId(getSenderId());
            conversation.setTargetName(getSender_name());
            conversation.setTargetPicture(getSender_picture());
            Conversation tmp = ConversationController.queryById(conversation.getTargetId());
            if (tmp != null) {
                if(tmp.getTimestamp() == conversation.getTimestamp()){
                    conversation.setUnreadNum(tmp.getUnreadNum());
                }else {
                    conversation.setUnreadNum(tmp.getUnreadNum()+1);
                }
            }else {
                conversation.setUnreadNum(1);
            }
        } else {
            conversation.setTargetId(getReceiverId());
            conversation.setTargetName(getReceiver_name());
            conversation.setTargetPicture(getReceiver_picture());
            Conversation tmp = ConversationController.queryById(conversation.getTargetId());
            conversation.setUnreadNum(tmp == null ? 0 : tmp.getUnreadNum());
        }
        return conversation;
    }

    @Override
    public void readFromJson(JsonReader reader) throws AppException {
        try {
            reader.beginObject();
            String node = null;
            while (reader.hasNext()) {
                node = reader.nextName();
                if (_ID.equals(node)) {
                    _id = reader.nextString();
                } else if (RECEIVER_NAME.equals(node)) {
                    receiver_name = reader.nextString();
                } else if (RECEIVERID.equals(node)) {
                    receiverId = reader.nextString();
                } else if (SENDER_NAME.equals(node)) {
                    sender_name = reader.nextString();
                } else if (SENDERID.equals(node)) {
                    senderId = reader.nextString();
                } else if (CONTENT.equals(node)) {
                    content = reader.nextString();
                } else if (CONTENT_TYPE.equals(node)) {
                    content_type = MessageType.valueOf(reader.nextString());
                } else if (TIMESTAMP.equals(node)) {
                    timestamp = reader.nextLong();
                }else if (ATTACHMENTS.equals(node)) {
                    reader.beginArray();
                    attachments = new ArrayList<Attachment>();
                    Attachment attachment = null;
                    while (reader.hasNext()) {
                        attachment = new Attachment();
                        attachment.readFromJson(reader);
                        attachments.add(attachment);
                    }
                    reader.endArray();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
