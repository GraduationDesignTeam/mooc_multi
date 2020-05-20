package com.mooc.mooc.vo;

import com.mooc.mooc.model.CourseInfo;
import com.mooc.mooc.model.UserInfo;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
public class CourseInfoVO {
    // 课程编号
    private Integer id;
    // 课程名称
    private String name;
    // 课程类型
    private String type;
    // 课程引言
    private String intro;
    // 课程概述
    private String detail;
    // 课程目标
    private String target;
    // 课程参考资料
    private String reference;
    // 课程封面图片
    private String photo;
    // 提供本课程的学校
    private String school;
    // 开设课程的教师
    private Integer teacherId;
    private String teacherName;
    // 开课时间
    private Date openTime;
    // 结课时间
    private Date closeTime;
    // 课程状态（0表示未开课；1表示已开课；2表示已结课）
    private Integer courseState;
    // 审核状态（0表示未通过；1表示已通过）
    private Integer checkState;
    // 课程权限（0表示所有人可选；1表示仅该学校学生可选）
    private Integer courseAuthority;
    // 授课教师列表
    private List<UserInfo> teacherList;

    /**
     * 以下为相对于 CourseInfo类 不同的属性
     */
    // 当前查询者在本课程中扮演的角色（0表示未知；1表示教师；2表示助教；3表示选课学生）
    private Integer role;

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
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        this.teacherName = teacherName;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<UserInfo> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<UserInfo> teacherList) {
        this.teacherList = teacherList;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public CourseInfoVO(){

    }

    public CourseInfoVO(CourseInfo courseInfo){
        this.id = courseInfo.getId();
        this.name = courseInfo.getName();
        this.type = courseInfo.getType();
        this.intro = courseInfo.getIntro();
        this.detail = courseInfo.getDetail();
        this.target = courseInfo.getTarget();
        this.reference = courseInfo.getReference();
        this.photo = courseInfo.getPhoto();
        this.school = courseInfo.getSchool();
        this.teacherId = courseInfo.getTeacherId();
        this.teacherName = courseInfo.getTeacherName();
        this.openTime = courseInfo.getOpenTime();
        this.closeTime = courseInfo.getCloseTime();
        this.courseState = courseInfo.getCourseState();
        this.checkState = courseInfo.getCheckState();
        this.courseAuthority = courseInfo.getCourseAuthority();
        this.teacherList = courseInfo.getTeacherList();
    }
}
