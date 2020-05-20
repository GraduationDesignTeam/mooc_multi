package com.mooc.mooc.service.impl;

import com.mooc.mooc.mapper.CourseChapterMapper;
import com.mooc.mooc.model.CourseChapter;
import com.mooc.mooc.service.CourseChapterService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseChapterServiceImpl implements CourseChapterService {
    @Autowired
    CourseChapterMapper courseChapterMapper;

    @Override
    public ResultVO add(CourseChapter chapter) {
        if(courseChapterMapper.insert(chapter) > 0)
            return new ResultVO(0, "章节添加成功");
        return new ResultVO(1, "章节添加失败，请稍后重试");
    }

    @Override
    public ResultVO update(CourseChapter chapter) {
        if(chapter.getName() == null || chapter.getName().trim().length()==0)
            return new ResultVO(1, "章节名不得为空!");
        courseChapterMapper.updateByPrimaryKey(chapter);
            return new ResultVO(0, "章节更新成功");
    }

    @Override
    @Transactional
    public ResultVO delete(Integer chapterId) {
        CourseChapter chapter=courseChapterMapper.selectByPrimaryKey(chapterId);
        if(chapter!=null){
            // 把本课程中所有比当前需要删除的章节序号大的都进行序号减一操作
            courseChapterMapper.decreaseNumber(chapter.getCourseId(), chapter.getNumber());
            courseChapterMapper.deleteByPrimaryKey(chapterId);
        }
        return new ResultVO(0, "删除成功");
    }

    @Override
    public List<CourseChapter> selectByCourseId(Integer courseId) {
        return courseChapterMapper.selectByCourseId(courseId);
    }
}
