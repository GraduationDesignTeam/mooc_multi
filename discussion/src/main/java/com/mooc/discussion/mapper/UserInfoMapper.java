package com.mooc.discussion.mapper;


import com.mooc.model.MajorStatistic;
import com.mooc.model.UserInfo;
import com.mooc.model.UserStatistic;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectByUsername(String username);

    List<UserInfo> queryAll(UserInfo userInfo);

    List<UserStatistic> queryMonthSum(Integer year);

    List<MajorStatistic> queryMajorSum(Integer year);
}