package com.mooc.courseware.service;

import com.mooc.courseware.mapper.CourseWareMapper;
import com.mooc.courseware.model.CourseWare;
import com.mooc.courseware.util.FileHelper;
import com.mooc.courseware.vo.CourseWareVO;
import com.mooc.courseware.vo.ResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CourseWareServiceImpl implements CourseWareService {
    @Resource
    private CourseWareMapper courseWareMapper;
    @Value("${web.course-ware-upload-path}")
    private String courseWarePath;

    @Override
    public ResultVO add(CourseWare courseWare) {
        courseWare.setUploadTime(new Date());
        if(courseWareMapper.insert(courseWare) > 0)
            return new ResultVO(0, "课件创建成功");
        return new ResultVO(1, "课件添加过程中出错，请稍后重试！");
    }

    @Override
    public ResultVO update(CourseWare courseWare) {
        courseWare.setUploadTime(new Date());
        if(courseWareMapper.updateByPrimaryKey(courseWare) > 0)
            return new ResultVO(0, "课件信息更新成功");
        return new ResultVO(1, "课件更新过程中出错，请稍后重试！");
    }

    @Override
    public ResultVO delete(Integer courseWareId) {
        CourseWareVO courseWare = courseWareMapper.selectByPrimaryKey(courseWareId);
        FileHelper.delete(courseWarePath, courseWare.getName());
        courseWareMapper.deleteByPrimaryKey(courseWareId);
        return new ResultVO(0, "课件删除成功");
    }

    @Override
    public List<CourseWareVO> selectBySectionId(Integer sectionId) {
        return courseWareMapper.selectBySectionId(sectionId);
    }

    @Override
    public List<CourseWareVO> selectByCourseId(Integer courseId) {
        return courseWareMapper.selectByCourseId(courseId);
    }

    @Override
    public List<CourseWareVO> selectUnassociatedByCourseId(Integer courseId) {
        return courseWareMapper.selectUnassociatedByCourseId(courseId);
    }
}
