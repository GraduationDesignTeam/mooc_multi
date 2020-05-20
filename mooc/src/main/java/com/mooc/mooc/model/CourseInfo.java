package com.mooc.mooc.model;

import com.mooc.mooc.util.StringFormatUtil;

import java.util.Date;
import java.util.List;

public class CourseInfo {
    private Integer id;

    private String name;

    private String type;

    private String intro;

    private String detail;

    private String target;

    private String reference;

    private String photo;

    private String school;

    private Integer teacherId;

    private String teacherName;

    private Date openTime;

    private Date closeTime;

    private Integer courseState;

    private Integer checkState;

    private Integer courseAuthority;

    // 授课教师列表
    private List<UserInfo> teacherList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = StringFormatUtil.trimEnd(detail);
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = StringFormatUtil.trimEnd(target);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference == null ? null : reference.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getCourseState() {
        return courseState;
    }

    public void setCourseState(Integer courseState) {
        this.courseState = courseState;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public Integer getCourseAuthority() {
        return courseAuthority;
    }

    public void setCourseAuthority(Integer courseAuthority) {
        this.courseAuthority = courseAuthority;
    }

    public List<UserInfo> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<UserInfo> teacherList) {
        this.teacherList = teacherList;
    }

    public CourseInfo() {
    }
}