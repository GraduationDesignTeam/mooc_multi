package com.mooc.mooc.service;

import com.mooc.mooc.model.SubjectiveOfQuestion;
import com.mooc.mooc.vo.ResultVO;

import java.util.List;

public interface SubjectiveQuestionService {
    // 查询任务
    List<SubjectiveOfQuestion> list(SubjectiveOfQuestion subjectiveOfQuestion);

    // 更新任务（注：默认输入参数中的课程id存在）
    ResultVO update(SubjectiveOfQuestion subjectiveOfQuestion);

    // 根据id删除任务
    ResultVO delete(Integer taskId);

    // 教师添加任务
    ResultVO add(SubjectiveOfQuestion subjectiveOfQuestion);

    // 教师撤销任务（删除未开始的任务）
    ResultVO cancel(Integer choiceId);

    // 根据id查询某课程
    SubjectiveOfQuestion sel(Integer choiceId);
    // 查询草稿
    List<SubjectiveOfQuestion> listdraft();

    // 查询草稿
    List<SubjectiveOfQuestion> listtask(Integer taskId);
}
