package com.mooc.mooc.service;

import com.mooc.mooc.model.CourseSection;
import com.mooc.mooc.vo.ResultVO;

public interface CourseSectionService {
    ResultVO add(CourseSection section);
    ResultVO update(CourseSection section);
    ResultVO delete(Integer sectionId);
//    List<CourseChapter> selectByChapterId(Integer chapterId);
}
