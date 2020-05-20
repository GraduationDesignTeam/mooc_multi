package com.mooc.coursenotice.service;

import com.github.pagehelper.PageInfo;
import com.mooc.coursenotice.model.CourseNotice;
import com.mooc.coursenotice.vo.CourseNoticeVO;
import com.mooc.model.ResultVO;

public interface CourseNoticeService {
    ResultVO add(CourseNotice courseNotice);
    ResultVO delete(Integer courseNoticeId);
    PageInfo<CourseNoticeVO> list(Integer currPage, Integer pageSize, Integer courseId);
}
