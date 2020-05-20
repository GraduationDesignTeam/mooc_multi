package com.mooc.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
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
}