package com.mooc.mooc.mapper;

import com.mooc.mooc.model.MajorStatistic;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.model.UserStatistic;

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