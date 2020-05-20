package com.mooc.discussion.mapper;


import com.mooc.discussion.model.DiscussRecord;

import java.util.List;

public interface DiscussRecordMapper {
    int deleteByPrimaryKey(Integer discussRecordId);

    int insert(DiscussRecord record);

    DiscussRecord selectByPrimaryKey(Integer discussRecordId);

    List<DiscussRecord> selectAll();

    int updateByPrimaryKey(DiscussRecord record);

    List<DiscussRecord> selByDiscussionId(Integer discussionId);

    List<DiscussRecord> selectByUserId(Integer userId);
}