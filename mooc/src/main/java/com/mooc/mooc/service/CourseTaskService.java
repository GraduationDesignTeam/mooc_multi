package com.mooc.mooc.service;

import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.CourseTask;
import com.mooc.mooc.vo.ResultVO;

public interface CourseTaskService {
    // 查询任务
    PageInfo<CourseTask> list(Integer currPage, Integer pageSize, CourseTask courseTask);

    // 更新任务（注：默认输入参数中的课程id存在）
    ResultVO update(CourseTask courseTask);

    // 根据id删除任务
    ResultVO delete(Integer taskId);

    // 教师添加任务
    ResultVO add(CourseTask courseTask);

    // 教师撤销任务（删除未开始的任务）
    ResultVO cancel(Integer taskId);

    // 根据id查询某课程
    CourseTask sel(Integer taskId);

    // 查询任务
    PageInfo<CourseTask> listAll(Integer currPage, Integer pageSize, Integer courseId);

    // 查询任务
    PageInfo<CourseTask> listExamAll(Integer currPage, Integer pageSize, Integer courseId);

    // 查询任务
    PageInfo<CourseTask> listTaskAll(Integer currPage, Integer pageSize, Integer courseId);
}
