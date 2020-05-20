package com.mooc.mooc.mapper;

import com.mooc.mooc.model.JudgeOfQuestion;

import java.util.List;

public interface JudgeOfQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JudgeOfQuestion record);

    JudgeOfQuestion selectByPrimaryKey(Integer id);

    List<JudgeOfQuestion> selectAll();

    int updateByPrimaryKey(JudgeOfQuestion record);

    List<JudgeOfQuestion> selectAllByType(Integer type);

    List<JudgeOfQuestion> selectAllByTask(Integer taskId);
}