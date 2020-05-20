package com.mooc.mooc.service;

import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.MajorStatistic;
import com.mooc.mooc.model.UserDiscussion;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.vo.ResultVO;
import com.mooc.mooc.vo.StatisticVO;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String,Object> login(UserInfo userInfo);

    List<UserDiscussion> getUserDiscussion();

    ResultVO add(UserInfo userInfo);

    ResultVO update(UserInfo userInfo);

    UserInfo checkSelfInfo(Integer userId);

    UserInfo checkOtherInfo(Integer targetId);

    UserInfo selByUsername(String name);

    ResultVO delete(Integer userId);

    PageInfo<UserInfo> list(Integer currPage, Integer pageSize, UserInfo userInfo);

    StatisticVO increaseRate(Integer year);

    List<MajorStatistic> majorRank(Integer year);

    UserInfo sel(Integer userId);
}
