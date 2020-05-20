package com.mooc.coursenotice.vo;

import com.mooc.coursenotice.model.CourseNotice;
import lombok.Data;

import java.util.Date;

@Data
public class CourseNoticeVO {
    private Integer id;

    private Integer courseId;

    private Integer userId;

    private String content;

    private Date createTime;

    // 发布者的用户名
    private String username;

    // 发布者的姓名
    private String name;

    public CourseNoticeVO(){}

    public CourseNoticeVO(CourseNotice notice){
        this.id = notice.getId();
        this.courseId = notice.getCourseId();
        this.userId = notice.getUserId();
        this.content = notice.getContent();
        this.createTime = notice.getCreateTime();
    }
}
