package com.mooc.mooc.mapper;

import com.mooc.mooc.model.JudgeAnswer;

import java.util.List;

public interface JudgeAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JudgeAnswer record);

    JudgeAnswer selectByPrimaryKey(Integer id);

    List<JudgeAnswer> selectAll();

    int updateByPrimaryKey(JudgeAnswer record);
}