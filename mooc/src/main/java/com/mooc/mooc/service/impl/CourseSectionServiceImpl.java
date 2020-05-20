package com.mooc.mooc.service.impl;

import com.mooc.mooc.mapper.CourseSectionMapper;
import com.mooc.mooc.model.CourseSection;
import com.mooc.mooc.service.CourseSectionService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseSectionServiceImpl implements CourseSectionService {
    @Autowired
    private CourseSectionMapper courseSectionMapper;
    
    @Override
    public ResultVO add(CourseSection section) {
        if(courseSectionMapper.insert(section) > 0)
            return new ResultVO(0, "小节添加成功");
        return new ResultVO(1, "小节添加失败，请稍后重试");
    }

    @Override
    public ResultVO update(CourseSection section) {
        if(section.getName() == null || section.getName().trim().length()==0)
            return new ResultVO(1, "小节名不得为空!");
        courseSectionMapper.updateByPrimaryKey(section);
        return new ResultVO(0, "小节更新成功");
    }

    @Override
    @Transactional
    public ResultVO delete(Integer sectionId) {
        CourseSection section=courseSectionMapper.selectByPrimaryKey(sectionId);
        if(section!=null){
            // 把本章节内所有比当前需要删除的小节序号大的都进行序号减一操作
            courseSectionMapper.decreaseNumber(section.getChapterId(), section.getNumber());
            courseSectionMapper.deleteByPrimaryKey(sectionId);
        }
        return new ResultVO(0, "删除成功");
    }
}
