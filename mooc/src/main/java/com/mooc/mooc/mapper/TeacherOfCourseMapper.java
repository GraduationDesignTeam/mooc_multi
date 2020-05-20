package com.mooc.mooc.mapper;

import com.mooc.mooc.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherOfCourseMapper {
    int deleteByPrimaryKey(@Param("courseId") Integer courseId, @Param("teacherId") Integer teacherId);

    int insert(@Param("courseId") Integer courseId, @Param("teacherId") Integer teacherId);

    List<UserInfo> selectTeacherOfCourse(@Param("courseId") Integer courseId);

    Integer count(@Param("courseId") Integer courseId, @Param("teacherId") Integer teacherId);
}