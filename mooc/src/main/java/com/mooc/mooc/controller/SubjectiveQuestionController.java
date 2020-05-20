package com.mooc.mooc.controller;

import com.mooc.mooc.model.CourseTask;
import com.mooc.mooc.model.SubjectiveOfQuestion;
import com.mooc.mooc.service.SubjectiveQuestionService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程控制器模块
 */
@RestController
@RequestMapping("/subjective")
public class SubjectiveQuestionController {
    @Resource
    private SubjectiveQuestionService subjectiveQuestionService;

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表

     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/listdraft")
    public List<SubjectiveOfQuestion> list(@RequestBody CourseTask coursetask){
        return subjectiveQuestionService.listdraft();
    }
    /**
     * @author 田冠宇
     * 教师在后台页面新建任务
     * @param subjectiveOfQuestion 课程信息
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/add")
    public ResultVO add(@RequestBody SubjectiveOfQuestion subjectiveOfQuestion){
        return subjectiveQuestionService.add(subjectiveOfQuestion);
    }

    /**
     * @author 田冠宇
     * 教师在后台页面新建任务
     * @param subjectiveOfQuestion 课程信息
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody SubjectiveOfQuestion subjectiveOfQuestion){
        return subjectiveQuestionService.update(subjectiveOfQuestion);
    }

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表

     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/listtask")
    public List<SubjectiveOfQuestion> listtask(@RequestBody CourseTask coursetask){
        return subjectiveQuestionService.listtask(coursetask.getId());
    }
    /**
     * @author 田冠宇
     * 教师在后台页面新建任务
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody SubjectiveOfQuestion subjectiveOfQuestion){
        return subjectiveQuestionService.delete(subjectiveOfQuestion.getId());
    }
}