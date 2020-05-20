package com.mooc.mooc.service;

import com.mooc.mooc.model.PersonMessage;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.vo.ResultVO;

import java.util.List;

public interface PersonalMessageService {
    // 查询任务
    List<PersonMessage> list(PersonMessage personMessage);

    // 更新任务（注：默认输入参数中的课程id存在）
    ResultVO update(PersonMessage personMessage);

    // 根据id删除任务
    ResultVO delete(Integer msgId);

    // 教师添加任务
    ResultVO add(PersonMessage personMessage);

    // 教师撤销任务（删除未开始的任务）
    ResultVO cancel(Integer msgId);

    // 根据id查询某课程
    PersonMessage sel(Integer msgId);

    // 根据id查询某课程
    UserInfo getUser(Integer userId);
    //根据id搜索2人的聊天记录
    List<PersonMessage> query(Integer posterId, Integer userId);
}
