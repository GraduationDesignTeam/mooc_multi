package com.mooc.mooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mooc.mooc.mapper.ChoiceOfQuestionMapper;
import com.mooc.mooc.mapper.CourseTaskMapper;
import com.mooc.mooc.mapper.JudgeOfQuestionMapper;
import com.mooc.mooc.mapper.SubjectiveOfQuestionMapper;
import com.mooc.mooc.model.ChoiceOfQuestion;
import com.mooc.mooc.model.CourseTask;
import com.mooc.mooc.model.JudgeOfQuestion;
import com.mooc.mooc.model.SubjectiveOfQuestion;
import com.mooc.mooc.service.CourseTaskService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTaskServiceImpl implements CourseTaskService {

    @Autowired
    private ChoiceOfQuestionMapper choiceOfQuestionMapper;
    @Autowired
    private CourseTaskMapper courseTaskMapper;
    @Autowired
    private SubjectiveOfQuestionMapper subjectiveOfQuestionMapper;
    @Autowired
    private JudgeOfQuestionMapper judgeOfQuestionMapper;
    @Override
    public PageInfo<CourseTask> list(Integer currPage, Integer pageSize, CourseTask courseTask) {

        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        return new PageInfo<>(courseTaskMapper.selectAllByCourse(courseTask.getCourseId()));
    }

    @Override
    public ResultVO update(CourseTask courseTask) {
        ResultVO resultVO=new ResultVO(0, "");
        courseTaskMapper.updateByPrimaryKey(courseTask);


        return resultVO;
    }

    @Override
    public ResultVO delete(Integer taskId) {
        return null;
    }

    @Override
    public ResultVO add(CourseTask courseTask) {

        ResultVO resultVO=new ResultVO(0, "");
        courseTaskMapper.insert(courseTask);
        CourseTask courseTask1=courseTaskMapper.selectByName(courseTask.getName().toString());
        System.out.println(courseTask1.getId());
        List<ChoiceOfQuestion> list_choice=choiceOfQuestionMapper.selectAllByType(0);
        List<JudgeOfQuestion> list_judge=judgeOfQuestionMapper.selectAllByType(0);
        List<SubjectiveOfQuestion> list_subjective=subjectiveOfQuestionMapper.selectAllByType(0);
        for(int i=0;i<list_choice.size();i++){
            list_choice.get(i).setCourseId(courseTask1.getCourseId());
            list_choice.get(i).setTaskId(courseTask1.getId());
            list_choice.get(i).setType(1);
            choiceOfQuestionMapper.updateByPrimaryKey(list_choice.get(i));
        }
        for(int i=0;i<list_judge.size();i++){
            list_judge.get(i).setCourseId(courseTask1.getCourseId());
            list_judge.get(i).setTaskId(courseTask1.getId());
            list_judge.get(i).setType(1);
            judgeOfQuestionMapper.updateByPrimaryKey(list_judge.get(i));
        }
        for(int i=0;i<list_subjective.size();i++){
            list_subjective.get(i).setCourseId(courseTask1.getCourseId());
            list_subjective.get(i).setTaskId(courseTask1.getId());
            list_subjective.get(i).setType(1);
            subjectiveOfQuestionMapper.updateByPrimaryKey(list_subjective.get(i));
        }

        return resultVO;
    }

    @Override
    public ResultVO cancel(Integer taskId) {
        return null;
    }

    @Override
    public CourseTask sel(Integer taskId) {

        return courseTaskMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public PageInfo<CourseTask> listAll(Integer currPage, Integer pageSize, Integer courseId) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        return new PageInfo<>(courseTaskMapper.selectAllByCourse(courseId));
    }

    @Override
    public PageInfo<CourseTask> listExamAll(Integer currPage, Integer pageSize, Integer courseId) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        return new PageInfo<>(courseTaskMapper.selectExamAllByCourse(courseId));
    }

    @Override
    public PageInfo<CourseTask> listTaskAll(Integer currPage, Integer pageSize, Integer courseId) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        return new PageInfo<>(courseTaskMapper.selectTaskAllByCourse(courseId));
    }
}
