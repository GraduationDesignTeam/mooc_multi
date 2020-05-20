package com.mooc.discussion.mapper;


import com.mooc.model.CourseInfo;
import com.mooc.model.CourseStatistic;
import com.mooc.model.MajorStatistic;

import java.util.List;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseInfo record);

    CourseInfo selectByPrimaryKey(Integer id);

    List<CourseInfo> selectAll();

    int updateByPrimaryKey(CourseInfo record);

    List<CourseInfo> queryAll(CourseInfo courseInfo);

    List<CourseInfo> selectByTeacherId(Integer teacherId);

    List<CourseInfo> selectByAssistantId(Integer assistantId);

    List<MajorStatistic> queryMajorSum(Integer year);

    List<CourseStatistic> queryCourseSum(Integer year);

    List<CourseInfo> selectByCreateTime(Integer limit);

    List<CourseInfo> selectByMostStudentNumber(Integer limit);
}