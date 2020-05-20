package com.mooc.mooc.service;

import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.CourseNotice;
import com.mooc.mooc.vo.CourseNoticeVO;
import com.mooc.mooc.vo.ResultVO;

public interface CourseNoticeService {
    ResultVO add(CourseNotice courseNotice);
    ResultVO delete(Integer courseNoticeId);
    PageInfo<CourseNoticeVO> list(Integer currPage, Integer pageSize, Integer courseId);
}
