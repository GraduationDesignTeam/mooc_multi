package com.mooc.mooc.model;

//查询用户信息时传进的对象，内涵当前用户id和目标用户id
public class ChangeForm {

    private Integer userId;

    private Integer targetId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }
}
