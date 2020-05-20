package com.mooc.model;

/**
 * @author 朱翔鹏
 * 用户专业分布统计数据封装对象
 */
public class MajorStatistic {

    //专业名称
    private String major;

    //数量
    private Integer num;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
