package com.mooc.mooc.service;

import com.mooc.mooc.model.JudgeOfQuestion;
import com.mooc.mooc.vo.ResultVO;

import java.util.List;

public interface JudgeQuestionService {
    // 查询任务
    List<JudgeOfQuestion> list(JudgeOfQuestion judgeOfQuestion);

    // 更新任务（注：默认输入参数中的课程id存在）
    ResultVO update(JudgeOfQuestion judgeOfQuestion);

    // 根据id删除任务
    ResultVO delete(Integer taskId);

    // 教师添加任务
    ResultVO add(JudgeOfQuestion judgeOfQuestion);

    // 教师撤销任务（删除未开始的任务）
    ResultVO cancel(Integer choiceId);

    // 根据id查询某课程
    JudgeOfQuestion sel(Integer choiceId);

    // 查询草稿
    List<JudgeOfQuestion> listdraft();
    // 查询草稿
    List<JudgeOfQuestion> listtask(Integer taskId);
}
