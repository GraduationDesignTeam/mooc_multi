package com.mooc.mooc.service.impl;

import com.mooc.mooc.mapper.AssistantOfCourseMapper;
import com.mooc.mooc.mapper.TeacherOfCourseMapper;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.CourseManageService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManageServiceImpl implements CourseManageService {
    @Autowired
    private TeacherOfCourseMapper teacherOfCourseMapper;

    @Autowired
    AssistantOfCourseMapper assistantOfCourseMapper;

    @Override
    public Boolean isTeacherOfCourse(Integer courseId, Integer teacherId) {
        return teacherOfCourseMapper.count(courseId, teacherId) > 0;
    }

    @Override
    public Boolean isAssistantOfCourse(Integer courseId, Integer assistantId) {
        return assistantOfCourseMapper.count(courseId, assistantId) > 0;
    }

    @Override
    public ResultVO addTeacher(Integer courseId, Integer teacherId) {
        if(assistantOfCourseMapper.count(courseId, teacherId) > 0)
            return new ResultVO(2, "该用户已经是本课程的助教了，无法再次添加为教师！");
        try{
            teacherOfCourseMapper.insert(courseId, teacherId);
        } catch (Exception e){
            return new ResultVO(1, "请勿重复添加！");
        }
        return new ResultVO(0, "操作成功");
    }

    @Override
    public ResultVO addAssistant(Integer courseId, Integer assistantId) {
        if(teacherOfCourseMapper.count(courseId, assistantId) > 0)
            return new ResultVO(2, "该用户已经是本课程的教师了，无法再次添加为助教！");
        try{
            assistantOfCourseMapper.insert(courseId, assistantId);
        } catch (Exception e){
            return new ResultVO(1, "请勿重复添加！");
        }
        return new ResultVO(0, "操作成功");
    }

    @Override
    public ResultVO removeTeacher(Integer courseId, Integer teacherId) {
        teacherOfCourseMapper.deleteByPrimaryKey(courseId, teacherId);
        return new ResultVO(0, "操作成功");
    }

    @Override
    public ResultVO removeAssistant(Integer courseId, Integer assistantId) {
        assistantOfCourseMapper.deleteByPrimaryKey(courseId, assistantId);
        return new ResultVO(0, "操作成功");
    }

    @Override
    public List<UserInfo> selectTeacherOfCourse(Integer courseId) {
        return teacherOfCourseMapper.selectTeacherOfCourse(courseId);
    }

    @Override
    public List<UserInfo> selectAssistantOfCourse(Integer courseId) {
        return assistantOfCourseMapper.selectAssistantOfCourse(courseId);
    }
}
