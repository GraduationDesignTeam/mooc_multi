package com.mooc.mooc.mapper;

import com.mooc.mooc.model.PersonMessage;

import java.util.List;

public interface PersonMessageMapper {
    int deleteByPrimaryKey(Integer msgId);

    int insert(PersonMessage record);

    PersonMessage selectByPrimaryKey(Integer msgId);

    List<PersonMessage> selectAll();

    int updateByPrimaryKey(PersonMessage record);
    List<PersonMessage> selectTwo(Integer postId, Integer getId);

    PersonMessage selectOne(PersonMessage record);

}