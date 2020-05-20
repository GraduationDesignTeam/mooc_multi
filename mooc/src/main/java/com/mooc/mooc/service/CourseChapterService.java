package com.mooc.mooc.service;

import com.mooc.mooc.model.CourseChapter;
import com.mooc.mooc.vo.ResultVO;

import java.util.List;

public interface CourseChapterService {
    ResultVO add(CourseChapter chapter);
    ResultVO update(CourseChapter chapter);
    ResultVO delete(Integer chapterId);
    List<CourseChapter> selectByCourseId(Integer courseId);
}
