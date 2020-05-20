package com.mooc.coursenotice.controller;

import com.github.pagehelper.PageInfo;
import com.mooc.coursenotice.model.CourseNotice;
import com.mooc.coursenotice.service.CourseNoticeService;
import com.mooc.coursenotice.util.Define;
import com.mooc.coursenotice.vo.CourseNoticeVO;
import com.mooc.model.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 课程公告控制器
 * 用于设置授课教师、设置课程助教、发布课程公告等
 */
@RestController
@RequestMapping("/course_notice")
public class CourseNoticeController {
    @Autowired
    CourseNoticeService courseNoticeService;


    /**
     * 发布新的课程公告
     * @param courseNotice 公告信息
     * @return 是否成功
     */
    @RequestMapping("/add")
    public ResultVO add(@RequestBody CourseNotice courseNotice){
        return courseNoticeService.add(courseNotice);
    }

    /**
     * 删除公告
     * @param id 公告id
     * @return 是否成功
     */
    @RequestMapping("/del/{id}")
    public ResultVO del(@PathVariable Integer id){
        return courseNoticeService.delete(id);
    }

    /**
     * 分页查询某课程的公告
     * @param currPage 页号
     * @param courseId 课程编号
     * @return List<CourseNotice>
     * 检索结果表，按发布时间，最新的在前面
     */
    @RequestMapping("/list/{currPage}")
    public PageInfo<CourseNoticeVO> list(@PathVariable Integer currPage, @RequestParam Integer courseId){
        return courseNoticeService.list(currPage, Define.PAGE_SIZE, courseId);
    }
}
