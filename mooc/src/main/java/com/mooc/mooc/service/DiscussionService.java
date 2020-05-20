package com.mooc.mooc.service;

import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.DiscussionDetail;
import com.mooc.mooc.model.DiscussionInfo;
import com.mooc.mooc.model.DiscussionStatistic;
import com.mooc.mooc.model.MajorStatistic;
import com.mooc.mooc.vo.ResultVO;

import java.util.List;

public interface DiscussionService {

    // 查询讨论，排序从新到旧，默认方式
    PageInfo<DiscussionDetail> listNew(Integer currPage, Integer pageSize, DiscussionDetail discussionDetail);

    // 查询讨论，排序按热度从高到底
    PageInfo<DiscussionDetail> listHot(Integer currPage, Integer pageSize, DiscussionDetail discussionDetail);

    //打开某个讨论
    DiscussionDetail open(Integer discussionId, Integer currPage, Integer pageSize);

    // 查询个人所参与的讨论，排序按热度从高到底
    PageInfo<DiscussionDetail> listSelf(Integer currPage, Integer pageSize, Integer userId);

    ResultVO create(DiscussionInfo discussionInfo);

    DiscussionDetail openOne(Integer discussionId);

    DiscussionDetail update(DiscussionInfo discussionInfo);

    List<MajorStatistic> majorRank(Integer year);

    List<DiscussionStatistic> discussionRank(Integer year);

    ResultVO delete(Integer discussionId);
}
