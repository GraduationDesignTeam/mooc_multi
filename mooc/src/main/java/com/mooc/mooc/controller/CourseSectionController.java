package com.mooc.mooc.controller;

import com.mooc.mooc.model.CourseSection;
import com.mooc.mooc.service.CourseSectionService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 课程小节控制器
 */
@RestController
@RequestMapping("/section")
public class CourseSectionController {
    @Resource
    private CourseSectionService sectionService;

    /**
     * 添加小节
     * @param section 小节
     * @return 是否成功
     */
    @RequestMapping("/add")
    ResultVO add(@RequestBody CourseSection section){
        return sectionService.add(section);
    }

    /**
     * 重命名小节
     * @param section 小节
     * @return 是否成功
     */
    @RequestMapping("/update")
    ResultVO update(@RequestBody CourseSection section){
        return sectionService.update(section);
    }

    /**
     * 删除小节
     * @param sectionId 小节编号
     * @return 是否成功
     */
    @RequestMapping("/del/{sectionId}")
    ResultVO del(@PathVariable Integer sectionId){
        return sectionService.delete(sectionId);
    }
}
