package com.mooc.mooc.controller;

import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.CourseManageService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程管理控制器
 * 用于设置授课教师、设置课程助教等
 */
@RestController
@RequestMapping("/course_manage")
public class CourseManageController {

    @Resource
    private CourseManageService courseManageService;

    /**
     * @author 涂斌砚
     * 教师在后台页面查看某课程的所有任课教师
     * @param courseId 课程编号
     * @return
     * List<UserInfoVO>
     */
    @RequestMapping("/get_teacher/{courseId}")
    public List<UserInfo> getTeacherList(@PathVariable Integer courseId){
        return courseManageService.selectTeacherOfCourse(courseId);
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面为一门课程添加一位授课教师
     * @param courseId 课程编号
     * @param teacherId 教师编号
     * @return
     * 成功：ResultVO:{code:0;msg:”操作成功” }
     * 失败：ResultVO:{code:1;msg:”操作失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/add_teacher")
    public ResultVO setTeacherOfCourse(@RequestParam Integer courseId, @RequestParam Integer teacherId){
        return courseManageService.addTeacher(courseId, teacherId);
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面为一门课程移除一位授课教师
     * @param courseId 课程编号
     * @param teacherId 教师编号
     * @return
     * 成功：ResultVO:{code:0;msg:”操作成功” }
     * 失败：ResultVO:{code:1;msg:”操作失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/remove_teacher")
    public ResultVO removeTeacherOfCourse(@RequestParam Integer courseId, @RequestParam Integer teacherId){
        return courseManageService.removeTeacher(courseId, teacherId);
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面查看某课程的所有助教
     * @param courseId 课程编号
     * @return
     * List<UserInfoVO>
     */
    @RequestMapping("/get_assistant/{courseId}")
    public List<UserInfo> getAssistantList(@PathVariable Integer courseId){
        return courseManageService.selectAssistantOfCourse(courseId);
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面为一门课程添加一位助教
     * @param courseId 课程编号
     * @param assistantId 助教编号
     * @return
     * 成功：ResultVO:{code:0;msg:”操作成功” }
     * 失败：ResultVO:{code:1;msg:”操作失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/add_assistant")
    public ResultVO setAssistantOfCourse(@RequestParam Integer courseId, @RequestParam Integer assistantId){
        return courseManageService.addAssistant(courseId, assistantId);
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面为一门课程移除一位授课教师
     * @param courseId 课程编号
     * @param assistantId 助教编号
     * @return
     * 成功：ResultVO:{code:0;msg:”操作成功” }
     * 失败：ResultVO:{code:1;msg:”操作失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/remove_assistant")
    public ResultVO removeAssistantOfCourse(@RequestParam Integer courseId, @RequestParam Integer assistantId){
        return courseManageService.removeAssistant(courseId, assistantId);
    }
}
