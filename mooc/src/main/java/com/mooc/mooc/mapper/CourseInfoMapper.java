package com.mooc.mooc.mapper;

import com.mooc.mooc.model.CourseInfo;
import com.mooc.mooc.model.CourseStatistic;
import com.mooc.mooc.model.MajorStatistic;

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