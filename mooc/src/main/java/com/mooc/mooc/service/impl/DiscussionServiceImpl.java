package com.mooc.mooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mooc.mooc.mapper.CourseInfoMapper;
import com.mooc.mooc.mapper.DiscussRecordMapper;
import com.mooc.mooc.mapper.DiscussionInfoMapper;
import com.mooc.mooc.mapper.UserInfoMapper;
import com.mooc.mooc.model.*;
import com.mooc.mooc.service.DiscussionService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscussionServiceImpl implements DiscussionService {

    @Autowired
    private DiscussionInfoMapper discussionInfoMapper;

    @Autowired
    private DiscussRecordMapper discussRecordMapper;

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageInfo<DiscussionDetail> listNew(Integer currPage, Integer pageSize, DiscussionDetail discussionDetail) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        //最新讨论排序
        List<DiscussionDetail> list=discussionInfoMapper.queryAllNew(discussionDetail);
        for(DiscussionDetail discussionDetail1: list){
            discussionDetail1.setRecordNum(discussRecordMapper.selByDiscussionId(discussionDetail1.getDiscussionId()).size());
        }
        return new PageInfo<>(list);
    }
    @Override
    public PageInfo<DiscussionDetail> listHot(Integer currPage, Integer pageSize, DiscussionDetail discussionDetail) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        //最热讨论排序
        List<DiscussionDetail> list=discussionInfoMapper.queryAllHot(discussionDetail);
        for(DiscussionDetail discussionDetail1: list){
            discussionDetail1.setRecordNum(discussRecordMapper.selByDiscussionId(discussionDetail1.getDiscussionId()).size());
        }
        DiscussionDetail temp=new DiscussionDetail();
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(j).getRecordNum()>list.get(i).getRecordNum()){
                    temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        return new PageInfo<>(list);
    }

    @Override
    //@Cacheable(value="DiscussionDetail",key="#discussionId",unless="#result == null")
    public DiscussionDetail open(Integer discussionId, Integer currPage, Integer pageSize) {
        DiscussionDetail discussionDetail=discussionInfoMapper.selectByPrimaryKey(discussionId);
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        PageInfo<DiscussRecord> pageInfo=new PageInfo<>(discussRecordMapper.selByDiscussionId(discussionId));
        discussionDetail.setRecordList(pageInfo);
        discussionDetail.setRecordNum(discussRecordMapper.selByDiscussionId(discussionId).size());
        return discussionDetail;
    }

    @Override
    public PageInfo<DiscussionDetail> listSelf(Integer currPage, Integer pageSize, Integer userId) {
        //分页
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        List<DiscussRecord> list=discussRecordMapper.selectByUserId(userId);
        ArrayList<DiscussionDetail> list1=new ArrayList<DiscussionDetail>();
        for(DiscussRecord discussRecord: list){
            //是否已有该讨论
            Boolean isExist=false;
            for(DiscussionDetail discussionDetail: list1){
                if(discussionDetail.getDiscussionId().equals(discussRecord.getDiscussionId())){
                    isExist=true;
                    break;
                }
            }
            if(!isExist){
                list1.add(discussionInfoMapper.selectByPrimaryKey(discussRecord.getDiscussionId()));
            }
        }
        PageInfo<DiscussionDetail> pageInfo=new PageInfo<>(list1);
        return pageInfo;
    }

    /**
     * @author 朱翔鹏
     * 教师在所教课程页面下，讨论区功能中，点击创建新讨论，填写表单，传入后台，调用此接口
     * @param discussionInfo
     * @return
     * 成功创建：ResultVO:{code:0;msg:”创建成功” }
     * 创建失败：ResultVO:{code:1;msg:”创建失败” }【msg中应包含详细错误信息】
     */
    @Override
    public ResultVO create(DiscussionInfo discussionInfo) {
        discussionInfo.setDiscussionPopularity(0);
        discussionInfo.setDiscussionState(1);
        discussionInfoMapper.insert(discussionInfo);
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("创建成功");
        return resultVO;
    }

    /**
     ** Cacheable如果缓存没有值,则执行方法并缓存数据,如果缓存有值,则从缓存中获取值
     * value：缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name
     * key：缓存的key，默认为空，同上
     * unless参数的作用是：函数返回值符合表达式条件的，veto（否决）、不缓存
     换句话说，函数返回值符合条件的排除掉、只缓存其余不符合条件的
     * @param discussionId
     * @return
     */
    @Override
    public DiscussionDetail openOne(Integer discussionId) {
        return discussionInfoMapper.selectByPrimaryKey(discussionId);
    }

    /**
     * @author 朱翔鹏
     * 教师在所教课程页面下，讨论区功能中，进入讨论区管理页面（列表形式展示所有该教师创建的讨论），
     * 可以选择某个讨论，编辑其详细信息
     * CachePut保证方法被调用，又希望结果被缓存。
     *与@Cacheable区别在于是否每次都调用方法，常用于更新
     * @param discussionInfo
     * @return
     * 成功修改：ResultVO:{code:0;msg:”修改成功” }
     * 修改失败：ResultVO:{code:1;msg:”修改失败” }【msg中应包含详细错误信息】
     */
    @Override
    @CachePut(value="DiscussionDetail",key="#discussionInfo.discussionId")
    public DiscussionDetail update(DiscussionInfo discussionInfo) {
        discussionInfoMapper.updateByPrimaryKey(discussionInfo);
        return discussionInfoMapper.selectByPrimaryKey(discussionInfo.getDiscussionId());
    }

    @Override
    public List<MajorStatistic> majorRank(Integer year) {
        return discussionInfoMapper.queryMajorSum(year);
    }

    @Override
    public List<DiscussionStatistic> discussionRank(Integer year) {
        return discussionInfoMapper.queryDiscussionSum(year);
    }

    /**
     * @author 朱翔鹏
     * 教师在所教课程页面下，讨论区功能中，进入讨论区管理页面（列表形式展示所有该教师创建的讨论），
     * 可以删除某个讨论
     * CacheEvict   删除,从缓存中删除相关的key-value,用来标注在需要清除缓存元素的方法或类上
     * @param discussionId
     * @return
     * 成功删除：ResultVO:{code:0;msg:”删除成功” }
     * 删除失败：ResultVO:{code:1;msg:”删除失败” }【msg中应包含详细错误信息】
     */
    @Override
    @CacheEvict(value="DiscussionDetail",key="#discussionId")
    public ResultVO delete(Integer discussionId) {
        discussionInfoMapper.deleteByPrimaryKey(discussionId);
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("删除成功");
        return resultVO;
    }
}
