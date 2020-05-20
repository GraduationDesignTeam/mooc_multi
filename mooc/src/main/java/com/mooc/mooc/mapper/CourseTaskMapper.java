package com.mooc.mooc.mapper;

import com.mooc.mooc.model.CourseTask;

import java.util.List;

public interface CourseTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseTask record);

    CourseTask selectByPrimaryKey(Integer id);

    CourseTask selectByName(String name);

    List<CourseTask> selectAll();

    List<CourseTask> selectAllByCourse(Integer courseId);

    List<CourseTask> selectTaskAllByCourse(Integer courseId);

    List<CourseTask> selectExamAllByCourse(Integer courseId);

    int updateByPrimaryKey(CourseTask record);
}