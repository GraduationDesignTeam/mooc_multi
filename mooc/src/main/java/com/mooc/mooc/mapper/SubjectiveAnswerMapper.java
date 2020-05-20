package com.mooc.mooc.mapper;

import com.mooc.mooc.model.SubjectiveAnswer;

import java.util.List;

public interface SubjectiveAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectiveAnswer record);

    SubjectiveAnswer selectByPrimaryKey(Integer id);

    List<SubjectiveAnswer> selectAll();

    int updateByPrimaryKey(SubjectiveAnswer record);
}