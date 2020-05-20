package com.mooc.discussion.mapper;

import com.mooc.discussion.model.DiscussionDetail;
import com.mooc.discussion.model.DiscussionInfo;
import com.mooc.discussion.model.DiscussionStatistic;
import com.mooc.model.MajorStatistic;

import java.util.List;

public interface DiscussionInfoMapper {
    int deleteByPrimaryKey(Integer discussionId);

    int insert(DiscussionInfo record);

    DiscussionDetail selectByPrimaryKey(Integer discussionId);

    List<DiscussionInfo> selectAll();

    int updateByPrimaryKey(DiscussionInfo record);

    List<DiscussionDetail> queryAllNew(DiscussionDetail discussionDetail);

    List<DiscussionDetail> queryAllHot(DiscussionDetail discussionDetail);

    List<MajorStatistic> queryMajorSum(Integer year);

    List<DiscussionStatistic> queryDiscussionSum(Integer year);
}