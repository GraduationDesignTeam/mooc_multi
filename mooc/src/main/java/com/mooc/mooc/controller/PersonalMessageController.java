package com.mooc.mooc.controller;

import com.mooc.mooc.model.PersonMessage;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.PersonalMessageService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/message")
public class PersonalMessageController {
    @Resource
    private PersonalMessageService personalMessageService;

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/getUser")
    public UserInfo getUser(@RequestBody UserInfo userInfo){

        return personalMessageService.getUser(userInfo.getUserId());
    }
    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/getAll")
    public List<PersonMessage> query(@RequestBody PersonMessage personMessage){

        return personalMessageService.query(personMessage.getMsgPost(),personMessage.getMsgGet());
    }

    /**
     * @author 田冠宇
     * 为首页提供分页查询任务列表
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @RequestMapping("/add")
    public PersonMessage add(@RequestBody PersonMessage personMessage){

        personalMessageService.add(personMessage);
        return personMessage;
    }
}
