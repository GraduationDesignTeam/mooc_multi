package com.mooc.mooc.mapper;

import com.mooc.mooc.model.ChoiceAnswer;

import java.util.List;

public interface ChoiceAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChoiceAnswer record);

    ChoiceAnswer selectByPrimaryKey(Integer id);

    List<ChoiceAnswer> selectAll();

    int updateByPrimaryKey(ChoiceAnswer record);
}