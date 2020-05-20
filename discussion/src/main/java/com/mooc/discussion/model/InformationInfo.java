package com.mooc.discussion.model;

import java.util.Date;

public class InformationInfo {
    private Integer informationId;

    private Integer senderId;

    private Integer addresserId;

    private Date sendTime;

    private String informationContent;

    private Integer informationState;//0表示未读，1表示已读读

    private Integer discussionId;

    private Integer discussRecordId;

    private Integer personMessageId;

    private String senderName;

    private String addresserName;

    private String remarks;//0表示私人消息，1表示讨论区消息，2表示系统消息

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getAddresserId() {
        return addresserId;
    }

    public void setAddresserId(Integer addresserId) {
        this.addresserId = addresserId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getInformationContent() {
        return informationContent;
    }

    public void setInformationContent(String informationContent) {
        this.informationContent = informationContent == null ? null : informationContent.trim();
    }

    public Integer getInformationState() {
        return informationState;
    }

    public void setInformationState(Integer informationState) {
        this.informationState = informationState;
    }

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public Integer getDiscussRecordId() {
        return discussRecordId;
    }

    public void setDiscussRecordId(Integer discussRecordId) {
        this.discussRecordId = discussRecordId;
    }

    public Integer getPersonMessageId() {
        return personMessageId;
    }

    public void setPersonMessageId(Integer personMessageId) {
        this.personMessageId = personMessageId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    public String getAddresserName() {
        return addresserName;
    }

    public void setAddresserName(String addresserName) {
        this.addresserName = addresserName == null ? null : addresserName.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}