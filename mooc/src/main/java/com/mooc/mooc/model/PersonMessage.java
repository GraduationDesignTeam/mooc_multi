package com.mooc.mooc.model;

import java.util.Date;

public class PersonMessage {
    private Integer msgId;

    private Integer msgType;

    private Integer msgPost;

    private Integer msgGet;

    private Date msgTime;

    private String msgContent;

    private String msgPostname;

    private String msgGetname;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getMsgPost() {
        return msgPost;
    }

    public void setMsgPost(Integer msgPost) {
        this.msgPost = msgPost;
    }

    public Integer getMsgGet() {
        return msgGet;
    }

    public void setMsgGet(Integer msgGet) {
        this.msgGet = msgGet;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public String getMsgPostname() {
        return msgPostname;
    }

    public void setMsgPostname(String msgPostname) {
        this.msgPostname = msgPostname == null ? null : msgPostname.trim();
    }

    public String getMsgGetname() {
        return msgGetname;
    }

    public void setMsgGetname(String msgGetname) {
        this.msgGetname = msgGetname == null ? null : msgGetname.trim();
    }
}