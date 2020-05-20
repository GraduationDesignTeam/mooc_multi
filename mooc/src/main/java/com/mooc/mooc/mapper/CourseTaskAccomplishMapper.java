package com.mooc.mooc.mapper;

import com.mooc.mooc.model.CourseTaskAccomplish;

import java.util.List;

public interface CourseTaskAccomplishMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseTaskAccomplish record);

    CourseTaskAccomplish selectByPrimaryKey(Integer id);

    List<CourseTaskAccomplish> selectAll();

    int updateByPrimaryKey(CourseTaskAccomplish record);
}