package com.mooc.mooc.controller;

import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.CourseInfo;
import com.mooc.mooc.model.CourseTask;
import com.mooc.mooc.service.CourseTaskService;
import com.mooc.mooc.util.Define;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 课程控制器模块
 */
@RestController
@RequestMapping("/coursetask")
public class CourseTaskController {
    @Resource
    private CourseTaskService courseTaskService;

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/listTaskAll/{currPage}")
    public PageInfo<CourseTask> listTaskAll(@PathVariable Integer currPage, @RequestBody CourseInfo course){
        PageInfo<CourseTask> list=courseTaskService.listTaskAll(currPage, Define.PAGE_SIZE,course.getId());
        //System.out.println(list1.getList().get(0).getProhibitState());

        return list;
    }
    /**
     * @author 田冠宇
     * 教师在后台页面新建任务
     * @param courseTask 课程信息
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/add")
    public ResultVO add(@RequestBody CourseTask courseTask){
        return courseTaskService.add(courseTask);
    }

    /**
     * @author 田冠宇
     * 教师在后台页面新建任务
     * @param courseTask 课程信息
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody CourseTask courseTask){
        return courseTaskService.update(courseTask);
    }

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/listExamAll/{currPage}")
    public PageInfo<CourseTask> listExamAll(@PathVariable Integer currPage, @RequestBody CourseInfo course){

        PageInfo<CourseTask> list=courseTaskService.listExamAll(currPage, Define.PAGE_SIZE,course.getId());
        //System.out.println(list1.getList().get(0).getProhibitState());

        return list;
    }

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/listAll/{currPage}")
    public PageInfo<CourseTask> listAll(@PathVariable Integer currPage, @RequestBody CourseInfo course){

        PageInfo<CourseTask> list=courseTaskService.listAll(currPage, Define.PAGE_SIZE,course.getId());
        //System.out.println(list1.getList().get(0).getProhibitState());

        return list;
    }

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/seltask")
    public CourseTask selByTaskId( @RequestBody CourseTask courseTask){

        return courseTaskService.sel(courseTask.getId());
    }

}
