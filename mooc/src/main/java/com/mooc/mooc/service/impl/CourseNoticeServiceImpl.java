package com.mooc.mooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mooc.mooc.mapper.CourseNoticeMapper;
import com.mooc.mooc.model.CourseNotice;
import com.mooc.mooc.service.CourseNoticeService;
import com.mooc.mooc.vo.CourseNoticeVO;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CourseNoticeServiceImpl implements CourseNoticeService {
    @Autowired
    CourseNoticeMapper courseNoticeMapper;


    @Override
    public ResultVO add(CourseNotice courseNotice) {
        courseNotice.setCreateTime(new Date());
        ResultVO resultVO = new ResultVO();
        if(courseNoticeMapper.insert(courseNotice) > 0){
            resultVO.setCode(0);
            resultVO.setMsg("创建成功");
        }else{
            resultVO.setCode(1);
            resultVO.setMsg("创建失败，请稍后重试");
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Integer courseNoticeId) {
        courseNoticeMapper.deleteByPrimaryKey(courseNoticeId);
        return new ResultVO(0, "删除成功");
    }

    @Override
    public PageInfo<CourseNoticeVO> list(Integer currPage, Integer pageSize, Integer courseId) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        return new PageInfo<>(courseNoticeMapper.selectByCourseId(courseId));
    }
}
