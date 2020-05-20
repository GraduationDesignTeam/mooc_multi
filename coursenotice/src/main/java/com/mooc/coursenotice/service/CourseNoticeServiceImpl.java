package com.mooc.coursenotice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mooc.client.MoocClient;
import com.mooc.coursenotice.mapper.CourseNoticeMapper;
import com.mooc.coursenotice.model.CourseNotice;
import com.mooc.coursenotice.vo.CourseNoticeVO;
import com.mooc.model.ResultVO;
import com.mooc.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseNoticeServiceImpl implements CourseNoticeService {
    @Resource
    CourseNoticeMapper courseNoticeMapper;
    @Resource
    MoocClient client;

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
        PageInfo<CourseNoticeVO> ret = new PageInfo<>();
        PageInfo<CourseNotice> pageInfo = new PageInfo<CourseNotice>(courseNoticeMapper.selectByCourseId(courseId));
        List<CourseNoticeVO> retList = new ArrayList<>();
        CourseNoticeVO vo;
        UserInfo user;
        List<CourseNotice> list = pageInfo.getList();
        for(CourseNotice notice: list) {
            vo = new CourseNoticeVO(notice);
            user = client.sel(notice.getUserId());
            vo.setName(user.getName());
            vo.setUsername(user.getUserName());
            retList.add(vo);
        }
        ret.setList(retList);
        ret.setPageNum(pageInfo.getPageNum());
        ret.setPageSize(pageInfo.getPageSize());
        ret.setTotal(pageInfo.getTotal());
        return ret;
    }
}
