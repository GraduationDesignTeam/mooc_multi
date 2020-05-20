package com.mooc.courseware.mapper;

import com.mooc.courseware.model.CourseWare;
import com.mooc.courseware.vo.CourseWareVO;

import java.util.List;

public interface CourseWareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseWare record);

    CourseWareVO selectByPrimaryKey(Integer id);

    List<CourseWareVO> selectBySectionId(Integer sectionId);

    List<CourseWareVO> selectByCourseId(Integer courseId);

    List<CourseWareVO> selectUnassociatedByCourseId(Integer courseId);

    int updateByPrimaryKey(CourseWare record);
}