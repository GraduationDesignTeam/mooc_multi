package com.mooc.mooc.mapper;

import com.mooc.mooc.model.CourseChapter;

import java.util.List;

public interface CourseChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int decreaseNumber(Integer courseId, Integer number);

    int insert(CourseChapter record);

    CourseChapter selectByPrimaryKey(Integer id);

    List<CourseChapter> selectByCourseId(Integer courseId);

    int updateByPrimaryKey(CourseChapter record);
}