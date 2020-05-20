package com.mooc.courseware.service;

import com.mooc.courseware.model.CourseWare;
import com.mooc.courseware.vo.CourseWareVO;
import com.mooc.courseware.vo.ResultVO;

import java.util.List;

public interface CourseWareService {
    ResultVO add(CourseWare courseWare);
    ResultVO update(CourseWare courseWare);
    ResultVO delete(Integer courseWareId);
    // 根据小节编号获取课件列表
    List<CourseWareVO> selectBySectionId(Integer sectionId);
    // 根据课程编号获取课件列表
    List<CourseWareVO> selectByCourseId(Integer courseId);
    // 根据课程编号获取未关联到小节的课件列表
    List<CourseWareVO> selectUnassociatedByCourseId(Integer courseId);
}
