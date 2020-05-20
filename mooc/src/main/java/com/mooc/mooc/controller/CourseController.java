package com.mooc.mooc.controller;

import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.CourseInfo;
import com.mooc.mooc.model.CourseStatistic;
import com.mooc.mooc.model.MajorStatistic;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.CourseService;
import com.mooc.mooc.util.Define;
import com.mooc.mooc.vo.CourseInfoVO;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程控制器模块
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /**
     * @author 朱翔鹏
     * 在数据统计功能下，管理员可以查看系统内课程的实时热度排行榜
     * （后续开发考虑使用某种形象的echart来展现）；并选择是否将其发布在门户网站中
     * @param courseInfo
     * CourseInfo,统计条件（同名/同专业/时间/同教师等）
     * @return
     * List<CourseStatistic>
     * List:用于(echarts)图表的数据list
     * 每个list项是一个CourseStatistic对象:{courseInfo,popularity}
     */
    @RequestMapping("/coursePopularity")
    public List<CourseStatistic> coursePopularity(@RequestBody CourseInfo courseInfo){
        return null;
    }

    /**
     * @author 朱翔鹏
     * 在数据统计功能下，管理员可以查看系统内所有课程的专业分布统计
     * @return
     * List<MajorStatistic>
     * List:用于echarts图表的数据list
     * 每个list项是一个MajorStatistic对象:{major,num}
     */
    @RequestMapping("/majorRank/{year}")
    public List<MajorStatistic> majorRank(@PathVariable Integer year){

        return courseService.majorRank(year);
    }
    @RequestMapping("/courseRank/{year}")
    public List<CourseStatistic> courseRank(@PathVariable Integer year){

        return courseService.courseRank(year);
    }

    /**
     * @author 朱翔鹏
     * 管理员处理开课请求，查看课程信息后，点击审核通过或不通过
     * @param courseInfo
     * @return
     * 审核通过：ResultVO{code:0,msg:”该课程通过审核”}
     * 审核不通过：ResultVO{code:1,msg:”该课程未通过审核”}
     */
    @RequestMapping("/verify")
    public ResultVO verify(@RequestBody CourseInfo courseInfo){
        return new ResultVO(0,"");
    }

    /**
     * @author 朱翔鹏
     * 管理员在课程管理页面（列表形式展示系统内所有开设状态的课程），点击某个课程，可以查看详细信息，
     * 点击封禁按钮，（倒数5秒）再点击确认封禁，则完成封禁操作，该课程权限变更为已封禁
     * @param courseId
     * @return
     * 成功封禁：ResultVO:{code:0;msg:”封禁成功” }
     * 封禁失败：ResultVO:{code:1;msg:”封禁失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/prohibit/{courseId}")
    public ResultVO  prohibit(@PathVariable Integer courseId){
        return new ResultVO(0,"");
    }

    /**
     * @author 朱翔鹏
     * 管理员在课程管理页面（列表形式展示系统内所有封禁状态的课程），点击某个课程，可以查看详细信息，
     * 点击解禁按钮，（倒数5秒）再点击确认解禁，则完成解禁操作，该课程权限变更为可选
     * @param courseId
     * @return
     * 成功解禁：ResultVO:{code:0;msg:”解禁成功” }
     * 解禁失败：ResultVO:{code:1;msg:”解禁失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/relieve/{courseId}")
    public ResultVO  relieve(@PathVariable Integer courseId){
        return new ResultVO(0,"");
    }

    /**
     * @author 朱翔鹏
     * 管理员在课程管理页面（列表形式展示系统内所有已结束状态的课程），点击某个课程，可以查看详细信息，
     * 点击删除按钮，（倒数5秒）再点击确认删除，则完成删除操作，该课程相关表记录、文件等全部从系统中删除
     * @param courseId
     * @return
     * 成功删除：ResultVO:{code:0;msg:”删除成功” }
     * 删除失败：ResultVO:{code:1;msg:”删除失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/delete/{courseId}")
    public ResultVO  delete(@PathVariable Integer courseId){
        return courseService.delete(courseId);
    }

    /**
     * @author 朱翔鹏
     * 面向所有用户，根据用户专业/近期参加课程/课程热度/开课时间/结课时间等多重要素，智能检索并排序结果
     * @param userId
     * @param courseInfo
     * userId,用户id
     * course,课程检索条件
     * @return
     *List<CourseInfo>
     * 检索结果表，按先后顺序
     * CourseInfo每个结果的课程信息
     */
    @RequestMapping("/search/{userId}")
    public List<CourseInfo> search(@PathVariable Integer userId,@RequestBody CourseInfo courseInfo){
        return null;
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面新建课程
     * @param courseInfo 课程信息
     * @return
     * 成功添加：ResultVO:{code:0;msg:”添加成功” }
     * 添加失败：ResultVO:{code:1;msg:”添加失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/add")
    public ResultVO add(@RequestBody CourseInfo courseInfo){
        return courseService.add(courseInfo);
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面更新课程信息
     * @param courseInfo 课程信息
     * @return
     * 成功更新：ResultVO:{code:0;msg:”更新成功” }
     * 更新失败：ResultVO:{code:1;msg:”更新失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody CourseInfo courseInfo){
        return courseService.update(courseInfo);
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面撤销一个未发布的课程
     * @param courseId 课程编号
     * @return
     * 成功撤销：ResultVO:{code:0;msg:”撤销成功” }
     * 撤销失败：ResultVO:{code:1;msg:”撤销失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/cancel/{courseId}")
    public ResultVO cancel(@PathVariable Integer courseId){
        return courseService.cancel(courseId);
    }

    /**
     * 教师在后台页面查看所有自己可管理的课程
     * @param teacherId
     * @return
     */
    @RequestMapping("/list_by_teacher_id")
    public List<CourseInfo> getByTeacherId(@RequestParam Integer teacherId){
        return courseService.getByTeacherId(teacherId);
    }

    /**
     * 助教在后台页面查看所有自己可管理的课程
     * @param assistantId
     * @return
     */
    @RequestMapping("/list_by_assistant_id")
    public List<CourseInfo> getByAssistantId(@RequestParam Integer assistantId){
        return courseService.getByAssistantId(assistantId);
    }

    /**
     * @author 涂斌砚
     * 为首页提供分页查询课程列表
     * @param currPage 页号
     * @param queryInfo 检索信息 - 可为空、课程名称、课程类别等
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/list/{currPage}")
    public PageInfo<CourseInfo> list(@PathVariable Integer currPage, @RequestBody CourseInfo queryInfo){
        PageInfo<CourseInfo> list1=courseService.list(currPage, Define.PAGE_SIZE,queryInfo);
        //System.out.println(list1.getList().get(0).getProhibitState());
        return list1;
    }

    /**
     * @author 涂斌砚
     * 查询某一门课程
     * 当用户编号为 0 时，默认为游客
     * @param courseId 课程编号
     * @param userId 用户编号
     * @return courseInfoVO
     */
    @RequestMapping("/sel/{courseId}")
    public CourseInfoVO selOne(@PathVariable Integer courseId, @RequestParam Integer userId){
        return courseService.selectVO(courseId, userId);
    }

    /**
     * @author 涂斌砚
     * 用于首页下方推荐课程
     * 按照课程创建顺序（越新的排在前面）拉取推荐课程列表 (最多8个）
     * @return 课程列表
     */
    @RequestMapping("/list_by_create_time")
    List<CourseInfo> selectByCreateTime(){
        return courseService.selectByCreateTime(8);
    }

    /**
     * @author 涂斌砚
     * 用于首页轮播图
     * 按照选课人数（越多的排在前面）拉取推荐课程列表 (最多5个）
     * @return 课程列表
     */
    @RequestMapping("/list_by_student_number")
    List<CourseInfo> selectByMostStudentNumber(){
        return courseService.selectByMostStudentNumber(5);
    }

    /**
     * @author朱翔鹏
     * 用户在个人主页查询自己(学生身份)所修课程
     * @param userInfo
     * @return
     */
    @RequestMapping("/selfList/{currPage}")
    public PageInfo<CourseInfoVO> selfList(@PathVariable Integer currPage, @RequestBody UserInfo userInfo){
        return courseService.selfList(currPage, Define.PAGE_SIZE,userInfo.getUserId());
    }
}
