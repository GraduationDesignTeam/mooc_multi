package com.mooc.mooc.model;

/**
 * @author 朱翔鹏
 * 讨论热度数据封装对象
 */
public class DiscussionStatistic {

    //讨论名
    private String discussionName;

    //热度值
    private Integer popularity;

    public String getDiscussionName() {
        return discussionName;
    }

    public void setDiscussionName(String discussionName) {
        this.discussionName = discussionName;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
}
