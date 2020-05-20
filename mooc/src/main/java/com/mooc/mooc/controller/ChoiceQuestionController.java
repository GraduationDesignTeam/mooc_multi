package com.mooc.mooc.controller;

import com.mooc.mooc.model.ChoiceOfQuestion;
import com.mooc.mooc.model.CourseTask;
import com.mooc.mooc.service.ChoiceQuestionService;
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
@RequestMapping("/choice")
public class ChoiceQuestionController {
    @Resource
    private ChoiceQuestionService choiceQuestionService;

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/listdraft")
    public List<ChoiceOfQuestion> list(@RequestBody CourseTask coursetask){
        return choiceQuestionService.listdraft();
    }
    /**
     * @author 田冠宇
     * 教师在后台页面新建任务
     * @param choiceOfQuestion 课程信息
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/add")
    public ResultVO add(@RequestBody ChoiceOfQuestion choiceOfQuestion){
        return choiceQuestionService.add(choiceOfQuestion);
    }

    /**
     * @author 田冠宇
     * 教师在后台页面新建任务
     * @param choiceOfQuestion 课程信息
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody ChoiceOfQuestion choiceOfQuestion){
        return choiceQuestionService.update(choiceOfQuestion);
    }

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/listtask")
    public List<ChoiceOfQuestion> listtask(@RequestBody CourseTask coursetask){
        System.out.println(coursetask.getId());
        return choiceQuestionService.listtask(coursetask.getId());
    }

    /**
     * @author 田冠宇
     * 教师在后台页面新建任务
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody ChoiceOfQuestion choiceOfQuestion){
        return choiceQuestionService.delete(choiceOfQuestion.getId());
    }

}
