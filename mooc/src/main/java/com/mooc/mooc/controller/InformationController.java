package com.mooc.mooc.controller;


import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.InformationInfo;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.InformationService;
import com.mooc.mooc.util.Define;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/information")
public class InformationController {

    @Resource
    private InformationService informationInfoservice;

    /**
     * 查看发送人的消息
     * @param userInfo 发送者id
     * @return 消息集合
     */
    @RequestMapping("/querybysender/{currPage}")
    public  PageInfo<InformationInfo> selbysenderid(@PathVariable Integer currPage,@RequestBody UserInfo userInfo){
        PageInfo<InformationInfo> list1=informationInfoservice.selBySenderId(currPage, Define.PAGE_SIZE,userInfo.getUserId());
        return list1;
    }

    /**
     * 查看收信息人的消息
     * @param userInfo 收信人id
     * @return 消息集合
     */
    @RequestMapping("/querybyaddresser/{currPage}")
    public  PageInfo<InformationInfo> selbyaddresserid(@PathVariable Integer currPage,@RequestBody UserInfo userInfo){
        PageInfo<InformationInfo> list1=informationInfoservice.selByAddresserId(currPage, Define.PAGE_SIZE,userInfo.getUserId());
        return list1;
    }

    /**
     * 添加消息
     * @param  informationInfo
     * @return 结果
     */
    @RequestMapping("/add")
    public ResultVO add(@RequestBody InformationInfo informationInfo){

        return informationInfoservice.add(informationInfo);
    }

    /**
     * 更新消息
     * @param  informationInfo
     * @return 结果
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody InformationInfo informationInfo){

        return informationInfoservice.update(informationInfo);
    }

    /**
     * 查看发送人的消息
     * @param userInfo 发送者id
     * @return 消息集合
     */
    @RequestMapping("/querydiscussion/{currPage}")
    public  PageInfo<InformationInfo> seldiscussion(@PathVariable Integer currPage,@RequestBody UserInfo userInfo){
        PageInfo<InformationInfo> list1=informationInfoservice.selDiscussion(currPage, Define.PAGE_SIZE,userInfo.getUserId());
        return list1;
    }
    /**
     * 查看发送人的消息
     * @param userInfo 发送者id
     * @return 消息集合
     */
    @RequestMapping("/querysystem/{currPage}")
    public  PageInfo<InformationInfo> selsystem(@PathVariable Integer currPage,@RequestBody UserInfo userInfo){
        PageInfo<InformationInfo> list1=informationInfoservice.selSystem(currPage, Define.PAGE_SIZE,userInfo.getUserId());
        return list1;
    }
    /**
     * @author 田冠宇
     * 取当前用户未读数量
     * @param userId
     * @return
     */
    @RequestMapping("/getUserMessageNum/{userId}")
    public Integer getUserMessageNum(@PathVariable Integer userId){

        return informationInfoservice.selunread().size();
    }
}
