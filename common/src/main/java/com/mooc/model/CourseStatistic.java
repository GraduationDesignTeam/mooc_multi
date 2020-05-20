package com.mooc.model;

/**
 * @author 朱翔鹏
 * 课程热度数据封装对象
 */
public class CourseStatistic {

    private String courseName;

    //热度值
    private Integer popularity;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
}
