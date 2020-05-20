package com.mooc.mooc.service.impl;

import com.mooc.mooc.mapper.InformationInfoMapper;
import com.mooc.mooc.mapper.PersonMessageMapper;
import com.mooc.mooc.mapper.UserInfoMapper;
import com.mooc.mooc.model.InformationInfo;
import com.mooc.mooc.model.PersonMessage;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.PersonalMessageService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalMessageImpl implements PersonalMessageService {

    @Autowired
    private PersonMessageMapper personMessageMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private InformationInfoMapper informationInfoMapper;
    @Override
    public List<PersonMessage> list(PersonMessage personMessage) {
        return null;
    }

    @Override
    public ResultVO update(PersonMessage personMessage) {
        return null;
    }

    @Override
    public ResultVO delete(Integer msgId) {
        return null;
    }

    @Override
    public ResultVO add(PersonMessage personMessage) {
        InformationInfo informationInfo=new InformationInfo();
        informationInfo.setSenderId(personMessage.getMsgPost());
        informationInfo.setAddresserId(personMessage.getMsgGet());
        informationInfo.setInformationState(0);
        informationInfo.setSendTime(personMessage.getMsgTime());
        informationInfo.setInformationContent(personMessage.getMsgContent());
        informationInfo.setRemarks("0");
        personMessage.setMsgGetname(userInfoMapper.selectByPrimaryKey(personMessage.getMsgGet()).getName());
        informationInfo.setAddresserName(userInfoMapper.selectByPrimaryKey(personMessage.getMsgGet()).getName());
        personMessage.setMsgPostname(userInfoMapper.selectByPrimaryKey(personMessage.getMsgPost()).getName());
        informationInfo.setSenderName(userInfoMapper.selectByPrimaryKey(personMessage.getMsgPost()).getName());
        personMessageMapper.insert(personMessage);
        PersonMessage a=personMessageMapper.selectOne(personMessage);
        informationInfo.setPersonMessageId(a.getMsgId());
        informationInfoMapper.insert(informationInfo);
        return null;
    }

    @Override
    public ResultVO cancel(Integer msgId) {
        return null;
    }

    @Override
    public PersonMessage sel(Integer msgId) {
        return null;
    }

    @Override
    public UserInfo getUser(Integer userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<PersonMessage> query(Integer posterId, Integer userId) {
        List <PersonMessage> list1=personMessageMapper.selectTwo(posterId,userId);
        for(int i=0;i<list1.size();i++)
            System.out.println(list1.get(i).getMsgContent());
        return list1;
    }




}
