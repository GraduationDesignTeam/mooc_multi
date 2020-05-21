package com.mooc.model;



import com.github.pagehelper.PageInfo;

import java.util.Date;

/**
 * @author 朱翔鹏
 * 讨论区详细信息封装类，包括开课教师名、所属课程名、管理助教名、回帖条数等数据项
 */
public class DiscussionDetail {

    private Integer discussionId;

    private String discussionName;

    private CourseInfo courseInfo;

    private Integer  courseId;

    private Integer teacherId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    private UserInfo teacher;

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    private Integer assistantId;

    private Integer discussionState;

    private String discussionDescription;

    private Date openDate;

    public UserInfo getTeacher() {
        return teacher;
    }

    public void setTeacher(UserInfo teacher) {
        this.teacher = teacher;
    }

    private Date closeDate;

    private Integer discussionAuthority;

    private Integer discussionPopularity;

    //回帖条数
    private Integer recordNum;

    //回帖清单
    private PageInfo<DiscussRecord> recordList;

    public PageInfo<DiscussRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(PageInfo<DiscussRecord> recordList) {
        this.recordList = recordList;
    }

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
        this.discussionName = discussionName;
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
        this.discussionDescription = discussionDescription;
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

    public Integer getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(Integer recordNum) {
        this.recordNum = recordNum;
    }
}
