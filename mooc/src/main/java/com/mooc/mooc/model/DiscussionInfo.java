package com.mooc.mooc.model;

import java.util.Date;

public class DiscussionInfo {
    private Integer discussionId;

    private String discussionName;

    private Integer courseId;

    private Integer teacherId;

    private Integer assistantId;

    private Integer discussionState;

    private String discussionDescription;

    private Date openDate;

    private Date closeDate;

    private Integer discussionAuthority;

    private Integer discussionPopularity;

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public String getDiscussionName() {
        return discussionName;
    }

    public void setDiscussionName(String discussionName) {
        this.discussionName = discussionName == null ? null : discussionName.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Integer assistantId) {
        this.assistantId = assistantId;
    }

    public Integer getDiscussionState() {
        return discussionState;
    }

    public void setDiscussionState(Integer discussionState) {
        this.discussionState = discussionState;
    }

    public String getDiscussionDescription() {
        return discussionDescription;
    }

    public void setDiscussionDescription(String discussionDescription) {
        this.discussionDescription = discussionDescription == null ? null : discussionDescription.trim();
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getDiscussionAuthority() {
        return discussionAuthority;
    }

    public void setDiscussionAuthority(Integer discussionAuthority) {
        this.discussionAuthority = discussionAuthority;
    }

    public Integer getDiscussionPopularity() {
        return discussionPopularity;
    }

    public void setDiscussionPopularity(Integer discussionPopularity) {
        this.discussionPopularity = discussionPopularity;
    }
}