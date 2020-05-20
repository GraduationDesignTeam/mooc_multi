package com.mooc.coursenotice.mapper;

import com.mooc.coursenotice.model.CourseNotice;

import java.util.List;

public interface CourseNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseNotice record);

    CourseNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(CourseNotice record);

    List<CourseNotice> selectByCourseId(Integer courseId);
}