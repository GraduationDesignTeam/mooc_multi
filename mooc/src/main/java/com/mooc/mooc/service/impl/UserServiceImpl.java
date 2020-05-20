package com.mooc.mooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mooc.mooc.mapper.UserDiscussionMapper;
import com.mooc.mooc.mapper.UserInfoMapper;
import com.mooc.mooc.model.MajorStatistic;
import com.mooc.mooc.model.UserDiscussion;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.UserService;
import com.mooc.mooc.vo.ResultVO;
import com.mooc.mooc.vo.StatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserDiscussionMapper userDiscussionMapper;

    /**
     * @author 朱翔鹏
     * 开发中临时用于登录
     * @param userInfo
     * @return map: code: 0-成功，1-用户名错误,2-密码错误; Object:userInfo对象
     */
    @Override
    public Map<String,Object> login(UserInfo userInfo) {
        Map<String,Object> map=new HashMap<>();
        int code=0;
        UserInfo userInfo1=userInfoMapper.selectByUsername(userInfo.getUserName());
        if(userInfo1==null){//用户名错
            code=1;
        }else{
            if(!userInfo1.getUserPassword().equals(userInfo.getUserPassword())){//密码错误
                code=2;
            }
        }
        map.put("code",code);
        map.put("user",userInfo1);
        return map;
    }

    @Override
    public List<UserDiscussion> getUserDiscussion() {
        return userDiscussionMapper.selectAll();
    }

    /**
     * @author 朱翔鹏
     * 用户新增时（新用户注册时），将用户填写的各项信息保存到数据库中
     * 1.	字段合法性验证
     * 2.	数据库合法性验证，验证user是否已存在
     * 3.	若验证失败则返回false和错误信息
     * @param userInfo
     * @return
     * 新增成功：ResultVO{code:0,msg:”新增成功”}
     * 验证到用户名重复：ResultVO{code:1,msg:”用户已存在”}
     * 验证到非法字段：ResultVO{code:2,msg:”用户名不能为空”}；3，“密码不能为空”；
     */
    @Override
    public ResultVO add(UserInfo userInfo) {
        ResultVO resultVO=new ResultVO();
        List<UserInfo> list=userInfoMapper.selectAll();
        for(int i=0;i<list.size();i++){
            if(userInfo.getUserName().equals("")||userInfo.getUserName().equals(null)){
                resultVO.setCode(2);
                resultVO.setMsg("用户名不能为空");
                return resultVO;
            }else if(userInfo.getUserPassword().equals("")||userInfo.getUserPassword().equals(null)){
                resultVO.setCode(3);
                resultVO.setMsg("密码不能为空");
                return resultVO;
            }else if(userInfo.getUserName().equals(list.get(i).getUserName())){
                resultVO.setCode(1);
                resultVO.setMsg("用户已存在");
                return resultVO;
            }
        }
        userInfo.setRegisterTime(new Date());
        userInfoMapper.insert(userInfo);
        resultVO.setCode(0);
        resultVO.setMsg("新增成功");
        return resultVO;
    }

    /**
     * @author 朱翔鹏
     * 用户可以修改个人信息，根据修改后的各项信息更新数据库
     * 1.	字段合法性验证
     * 2.	若验证失败则返回false和错误信息
     * @param userInfo
     * @return
     * 修改成功：ResultVO{code:0,msg:”修改成功”}
     * 验证到非法字段：ResultVO{code:2,msg:”用户名不能为空”}；3，“密码不能为空”；
     */
    @Override
    public ResultVO update(UserInfo userInfo) {
        ResultVO resultVO=new ResultVO();
        List<UserInfo> list=userInfoMapper.selectAll();
        for(int i=0;i<list.size();i++){
            if(userInfo.getUserName().equals("")||userInfo.getUserName().equals(null)){
                resultVO.setCode(2);
                resultVO.setMsg("用户名不能为空");
                return resultVO;
            }else if(userInfo.getUserPassword().equals("")||userInfo.getUserPassword().equals(null)){
                resultVO.setCode(3);
                resultVO.setMsg("密码不能为空");
                return resultVO;
            }
        }
        userInfoMapper.updateByPrimaryKey(userInfo);
        resultVO.setCode(0);
        resultVO.setMsg("修改成功");
        return resultVO;
    }

    /**
     * @author 朱翔鹏
     * 返回用户自己的信息
     * @param userId
     * @return
     */
    @Override
    public UserInfo checkSelfInfo(Integer userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    /**
     * @author 朱翔鹏
     * 返回所查看的其它用户的信息
     * @param targetId
     * @return
     * 用户的姓名，电话号码，密码等信息应该对其他人保密
     */
    @Override
    public UserInfo checkOtherInfo(Integer targetId) {
        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(targetId);
        userInfo.setPhone(null);
        userInfo.setName(null);
        userInfo.setUserPassword(null);
        return userInfo;
    }

    /**
     * 根据名字返回所查看的用户的信息
     * @param name
     * @return
     */
    @Override
    public UserInfo selByUsername(String name) {
        UserInfo userInfo=userInfoMapper.selectByUsername(name);
        return userInfo;
    }

    /**
     * @author 朱翔鹏
     * 用户决定注销账号（删除此账号）时，根据当前用户id删除数据库中对应的用户项
     *1.用户封禁状态验证，若已被封禁则不能注销
     * @param userId
     * @return
     * 成功注销并删除用户信息：ResultVO{code:0,msg:”注销成功” }
     * 查询到用户已被封禁：ResultVO{code:1,msg:”您已被封禁，暂时无法注销” }
     */
    @Override
    public ResultVO delete(Integer userId) {
        ResultVO resultVO=new ResultVO();
        if(checkSelfInfo(userId).getProhibitState()==1){
            //已被封禁
            resultVO.setCode(1);
            resultVO.setMsg("您已被封禁，暂时无法注销");
            return resultVO;
        }
        userInfoMapper.deleteByPrimaryKey(userId);
        resultVO.setCode(0);
        resultVO.setMsg("注销成功");
        return resultVO;
    }

    /**
     * @author 朱翔鹏
     * 更具条件分页查询用户 v1.0
     * @param currPage 现在在第几页
     * @param pageSize 每页几项
     * @param userInfo
     * @return
     */
    @Override
    public PageInfo<UserInfo> list(Integer currPage, Integer pageSize,UserInfo userInfo) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        PageInfo<UserInfo> userInfoPageInfo=new PageInfo<>(userInfoMapper.queryAll(userInfo));
        return userInfoPageInfo;
    }

    /**
     * @author 朱翔鹏
     *  在数据统计功能下，管理员可以查看年度用户增长趋势（以月为单位）的可视化图表数据，
     *  此处为折线图，另付平均月度增长率
     * @param year
     * @return
     * StatisticVO:{List<UserStatistic>,increaseRate}
     * List:用于echarts图表的数据list
     * 每个list项是一个UserStatistic对象:{year; month; num}
     * 		increaseRate:在后端计算好的平均月度增长率
     */
    @Override
    public StatisticVO increaseRate(Integer year) {
        StatisticVO statisticVO=new StatisticVO();
        statisticVO.setList(userInfoMapper.queryMonthSum(year));
        Double increaseRate=0.0;
        for(int i=1;i<statisticVO.getList().size();i++){
            increaseRate=increaseRate+(statisticVO.getList().get(i).getNum()-statisticVO.getList().get(i-1).getNum())/statisticVO.getList().get(i-1).getNum();
        }
        increaseRate=increaseRate/(statisticVO.getList().size()-1);
        statisticVO.setIncreaseRate(increaseRate);
        return statisticVO;
    }

    /**
     * @author 朱翔鹏
     * 在数据统计功能下，管理员可以查看系统内所有用户的专业分布排行榜
     * @return
     * List<MajorStatistic>
     * List:用于echarts图表的数据list
     * 每个list项是一个MajorStatistic对象:{major,num}
     */
    @Override
    public List<MajorStatistic> majorRank(Integer year) {
        return userInfoMapper.queryMajorSum(year);
    }

    /**
     * 根据 userId 查询用户
     * 这里返回结果中隐藏了 password
     * @param userId 用户编号
     * @return UserInfo
     */
    @Override
    public UserInfo sel(Integer userId) {
        UserInfo user = userInfoMapper.selectByPrimaryKey(userId);
        user.setUserPassword("");
        return user;
    }
}
