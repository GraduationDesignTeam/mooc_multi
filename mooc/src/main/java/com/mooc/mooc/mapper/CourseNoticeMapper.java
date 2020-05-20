package com.mooc.mooc.mapper;

import com.mooc.mooc.model.CourseNotice;
import com.mooc.mooc.vo.CourseNoticeVO;

import java.util.List;

public interface CourseNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseNotice record);

    CourseNoticeVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(CourseNotice record);

    List<CourseNoticeVO> selectByCourseId(Integer courseId);
}