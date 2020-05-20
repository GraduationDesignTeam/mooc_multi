package com.mooc.mooc.mapper;

import com.mooc.mooc.model.UserDiscussion;

import java.util.List;

public interface UserDiscussionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDiscussion record);

    UserDiscussion selectByPrimaryKey(Integer id);

    List<UserDiscussion> selectAll();

    int updateByPrimaryKey(UserDiscussion record);
}