package com.mooc.mooc.controller;

import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.ChangeForm;
import com.mooc.mooc.model.MajorStatistic;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.UserService;
import com.mooc.mooc.util.Define;
import com.mooc.mooc.vo.ResultVO;
import com.mooc.mooc.vo.StatisticVO;
import com.mooc.mooc.vo.UserInfoVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户模块控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


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
    @RequestMapping("/add")
    public ResultVO add(@RequestBody UserInfo userInfo){
        return userService.add(userInfo);
    }

    /**
     * @author 朱翔鹏
     * 用户可以修改个人信息，根据修改后的各项信息更新数据库
     * 1.	字段合法性验证
     * 2.	若验证失败则返回false和错误信息
     * @param userInfo
     * @return
     * 修改成功：ResultVO{code:0,msg:”修改成功”}
     * 验证到非法字段：ResultVO{code:1,msg:”信息填写有误”}
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody UserInfo userInfo){
        return userService.update(userInfo);
    }

    /**
     * @author 朱翔鹏
     * 用户查看自己或其他用户个人信息时，根据所查用户id从数据库取到信息后发给前端；
     * 需要注意用户大部分信息应为不可公开状态，他人查看时只显示基本身份信息
     *1.用户封禁状态验证，若已被封禁则不能查看信息
     * @param userId
     * @return
     *成功取到用户信息：UserInfoVO{code:0,msg:””，UserInfo：所查用户信息对象}
     * 注：若currUserId!=userId，则此处UserInfo中只包含用户编号、用户身份、用户名、学校、学历、专业、教师身份认证状态这几项
     * 查询到用户已被封禁：UserInfoVO{code:1,msg:”该用户已被封禁，无法查看信息”，UserInfo：null}
     */
    @RequestMapping("/checkInfo")
    public UserInfoVO checkInfo(@RequestBody ChangeForm changeForm){
        UserInfoVO userInfoVO=new UserInfoVO();
        if(changeForm.getUserId()==changeForm.getTargetId()){
            //用户查看自己的信息
            userInfoVO.setCode(0);
            userInfoVO.setMsg("查看自己的信息");
            userInfoVO.setUserInfo(userService.checkSelfInfo(changeForm.getTargetId()));
            return userInfoVO;
        }else{
            userInfoVO.setCode(1);
            userInfoVO.setMsg("查看他人的信息");
            userInfoVO.setUserInfo(userService.checkOtherInfo(changeForm.getTargetId()));
            return userInfoVO;
        }
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
    @RequestMapping("/delete/{userId}")
    public ResultVO delete(@PathVariable Integer userId){
        return userService.delete(userId);
    }

    /**
     * @author 朱翔鹏
     * 管理员封禁违规用户
     *1.用户封禁状态验证，若已被封禁则不能重复封禁
     * @param userId
     * @return
     * 成功封禁：ResultVO{code:0,msg:”封禁成功” }
     * 查询到用户已被封禁：ResultVO{code:1,msg:”该用户已被封禁，无需重复封禁” }
     */
    @RequestMapping("/prohibit/{userId}")
    public ResultVO prohibit(@PathVariable Integer userId){
        return new ResultVO(0,"");
    }


    /**
     * @author 朱翔鹏
     * 管理员解禁用户（管理员检索被封禁用户，对其中的某个进行解禁，所以无需验证是否被封禁）
     * @param userId
     * @return
     * 成功解禁：ResultVO{code:0,msg:”解禁成功” }
     * 解禁失败：ResultVO{code:1,msg:”解禁失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/relieve/{userId}")
    public ResultVO relieve(@PathVariable Integer userId){
        return new ResultVO(0,"");
    }

    /**
     * @author 朱翔鹏
     * 管理员查看教师信息，认证之后教师认证状态变为已认证（未认证教师无法开设课程；
     * 用户创建时选择身份为教师，则系统会将该用户置于管理员教师待认证队列，
     * 管理员可以在查看教师信息后，选择认证或者不予认证，两种情况系统都会向该用户发送相应的消息通知）
     * @param userId
     * @return
     * 认证成功：ResultVO{code:0,msg:”认证成功” }
     * 不予认证成功：ResultVO{code:1,msg:”不予认证成功” }
     */
    @RequestMapping("/checkTeacher/{userId}")
    public ResultVO checkTeacher(@PathVariable Integer userId){
        return new ResultVO(0,"");
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
    @RequestMapping("/increaseRate/{year}")
    public StatisticVO increaseRate(@PathVariable Integer year){
        return userService.increaseRate(year);
    }

    /**
     * @author 朱翔鹏
     * 在数据统计功能下，管理员可以查看系统内所有用户的专业分布排行榜
     * @return
     * List<MajorStatistic>
     * List:用于echarts图表的数据list
     * 每个list项是一个MajorStatistic对象:{major,num}
     */
    @RequestMapping("/majorRank/{year}")
    public List<MajorStatistic> majorRank(@PathVariable Integer year){

        return userService.majorRank(year);
    }

    /**
     * @author 朱翔鹏
     * 开发中临时用于登录的接口
     * @param userInfo
     * @return
     */
    @RequestMapping("/timelyLogin")
    public ResultVO timelyLogin(@RequestBody UserInfo userInfo){
        Map<String,Object> result=userService.login(userInfo);
        Integer code=(Integer)result.get("code");
        ResultVO resultVo=new ResultVO();
        resultVo.setCode(code);
        switch (code){
            case 0:
                resultVo.setMsg("登录成功");
                resultVo.setObject(result.get("user"));
                break;
            case 1:
                resultVo.setMsg("用户名错误");
                break;
            case 2:
                resultVo.setMsg("密码错误");
                break;
        }
        return resultVo;
    }

    /**
     * @author 朱翔鹏
     * 取当前用户参加的讨论区数量
     * @param userId
     * @return
     */
    @RequestMapping("/getUserDiscussionNum/{userId}")
    public Integer getUserDiscussionNum(@PathVariable Integer userId){
        return userService.getUserDiscussion().size();
    }

    /**
     * @author 朱翔鹏
     * 根据条件查询用户 v1.0
     * @param userInfo 查询条件
     * @return
     * List<UserInfo>用户信息对象集合list
     */
    @RequestMapping("/queryAll/{currPage}")
    public PageInfo<UserInfo> queryAll(@PathVariable Integer currPage, @RequestBody UserInfo userInfo){
        PageInfo<UserInfo> list1=userService.list(currPage, Define.PAGE_SIZE,userInfo);
        //System.out.println(list1.getList().get(0).getProhibitState());
        return list1;
    }

    /**
     * 根据userId查询用户
     * @param userId 用户编号
     * @return UserInfo
     */
    @RequestMapping("/sel/{userId}")
    public UserInfo sel(@PathVariable Integer userId){
        return userService.sel(userId);
    }
}
