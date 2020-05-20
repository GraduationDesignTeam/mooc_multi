package com.mooc.mooc.controller;

import com.mooc.mooc.model.CourseChapter;
import com.mooc.mooc.service.CourseChapterService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程章节控制器
 */
@RestController
@RequestMapping("/chapter")
public class CourseChapterController {
    @Resource
    private CourseChapterService courseChapterService;

    /**
     * 查看某课程的所有章节
     * 每个章节下方应带着小节
     * @param courseId 课程编号
     * @return 章节列表
     */
    @RequestMapping("/list/{courseId}")
    List<CourseChapter> selAll(@PathVariable Integer courseId){
        return courseChapterService.selectByCourseId(courseId);
    }

    /**
     * 添加章节
     * @param chapter 章节
     * @return 是否成功
     */
    @RequestMapping("/add")
    ResultVO<CourseChapter> add(@RequestBody CourseChapter chapter){
        return courseChapterService.add(chapter);
    }

    /**
     * 重命名章节
     * @param chapter 章节
     * @return 是否成功
     */
    @RequestMapping("/update")
    ResultVO update(@RequestBody CourseChapter chapter){
        return courseChapterService.update(chapter);
    }

    /**
     * 删除章节
     * 如果删除的章节并非最后一章，那么原本排在该章节之后的章节序号都会发生改动
     * @param chapterId 章节编号
     * @return 是否成功
     */
    @RequestMapping("/del/{chapterId}")
    ResultVO del(@PathVariable Integer chapterId){
        return courseChapterService.delete(chapterId);
    }
}
