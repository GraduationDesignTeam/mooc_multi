package com.mooc.mooc.vo;

import com.mooc.mooc.model.UserInfo;
import lombok.Data;

/**
 * @author 朱翔鹏
 * 封装了用户对象的展示层
 */
@Data
public class UserInfoVO {

    private Integer code;

    private String msg;

    private UserInfo userInfo;

    public UserInfoVO(){

    }

    public UserInfoVO(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
