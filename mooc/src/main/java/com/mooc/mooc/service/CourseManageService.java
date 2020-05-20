package com.mooc.mooc.service;

import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.vo.ResultVO;

import java.util.List;

public interface CourseManageService {
    Boolean isTeacherOfCourse(Integer courseId, Integer teacherId);
    Boolean isAssistantOfCourse(Integer courseId, Integer assistantId);
    ResultVO addTeacher(Integer courseId, Integer teacherId);
    ResultVO addAssistant(Integer courseId, Integer assistantId);
    ResultVO removeTeacher(Integer courseId, Integer teacherId);
    ResultVO removeAssistant(Integer courseId, Integer assistantId);
    List<UserInfo> selectAssistantOfCourse(Integer courseId);
    List<UserInfo> selectTeacherOfCourse(Integer courseId);
}
