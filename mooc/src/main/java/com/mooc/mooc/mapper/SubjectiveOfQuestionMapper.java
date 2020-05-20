package com.mooc.mooc.mapper;

import com.mooc.mooc.model.SubjectiveOfQuestion;

import java.util.List;

public interface SubjectiveOfQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectiveOfQuestion record);

    SubjectiveOfQuestion selectByPrimaryKey(Integer id);

    List<SubjectiveOfQuestion> selectAll();

    int updateByPrimaryKey(SubjectiveOfQuestion record);

    List<SubjectiveOfQuestion> selectAllByType(Integer type);

    List<SubjectiveOfQuestion> selectAllByTask(Integer taskId);
}