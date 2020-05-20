package com.mooc.mooc.mapper;

import com.mooc.mooc.model.StudentOfCourse;

import java.util.List;

public interface StudentOfCourseMapper {
    int deleteByPrimaryKey(Integer courseUserId);

    int insert(StudentOfCourse record);

    StudentOfCourse selectByPrimaryKey(Integer courseUserId);

    List<StudentOfCourse> selectAll();

    int updateByPrimaryKey(StudentOfCourse record);

    List<StudentOfCourse> selByUserId(Integer userId);

    Integer count(Integer courseId, Integer studentId);
}