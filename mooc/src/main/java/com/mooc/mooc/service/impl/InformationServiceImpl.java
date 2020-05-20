package com.mooc.mooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mooc.mooc.mapper.InformationInfoMapper;
import com.mooc.mooc.mapper.UserInfoMapper;
import com.mooc.mooc.model.InformationInfo;
import com.mooc.mooc.model.UserInfo;
import com.mooc.mooc.service.InformationService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationInfoMapper informationInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<InformationInfo> selAll() {
        return informationInfoMapper.selectAll();
    }

    @Override
    public PageInfo<InformationInfo> selBySenderId(Integer currPage, Integer pageSize, Integer senderid) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);

        List<InformationInfo> list = informationInfoMapper.selectBySenderid(senderid);
        for(int i=0;i<list.size();i++){
            UserInfo user=userInfoMapper.selectByPrimaryKey(list.get(i).getAddresserId());
            list.get(i).setAddresserName(user.getName());
            user=userInfoMapper.selectByPrimaryKey(list.get(i).getSenderId());
            list.get(i).setSenderName(user.getName());
            list.get(i).setInformationState(1);
            informationInfoMapper.updateByPrimaryKey(list.get(i));
        }
        PageInfo<InformationInfo> informationPageInfo=new PageInfo<>(informationInfoMapper.selectBySenderid(senderid));
        return informationPageInfo;
    }

    @Override
    public PageInfo<InformationInfo> selByAddresserId(Integer currPage, Integer pageSize, Integer addresserid) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        List<InformationInfo> list = informationInfoMapper.selectByAddresserid(addresserid);

        for(int i=0;i<list.size();i++){
            UserInfo user=userInfoMapper.selectByPrimaryKey(list.get(i).getSenderId());
            list.get(i).setSenderName(user.getName());
            user=userInfoMapper.selectByPrimaryKey(list.get(i).getAddresserId());
            list.get(i).setAddresserName(user.getName());
            list.get(i).setInformationState(1);
            informationInfoMapper.updateByPrimaryKey(list.get(i));
        }
        PageInfo<InformationInfo> informationPageInfo=new PageInfo<>(informationInfoMapper.selectByAddresserid(addresserid));
        return informationPageInfo;
    }

    @Override
    public PageInfo<InformationInfo> selDiscussion(Integer currPage, Integer pageSize, Integer addresserid) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        List<InformationInfo> list = informationInfoMapper.selectDiscussion(addresserid);
        for(int i=0;i<list.size();i++){
            UserInfo user=userInfoMapper.selectByPrimaryKey(addresserid);
            list.get(i).setAddresserName(user.getName());
            list.get(i).setInformationState(1);
            informationInfoMapper.updateByPrimaryKey(list.get(i));
        }
        PageInfo<InformationInfo> informationPageInfo=new PageInfo<>(informationInfoMapper.selectDiscussion(addresserid));
        return informationPageInfo;
    }

    @Override
    public PageInfo<InformationInfo> selSystem(Integer currPage, Integer pageSize, Integer addresserid) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        List<InformationInfo> list = informationInfoMapper.selectSystem(addresserid);
        for(int i=0;i<list.size();i++){
            UserInfo user=userInfoMapper.selectByPrimaryKey(addresserid);
            list.get(i).setAddresserName(user.getName());
            list.get(i).setInformationState(1);
            informationInfoMapper.updateByPrimaryKey(list.get(i));
        }
        PageInfo<InformationInfo> informationPageInfo=new PageInfo<>(informationInfoMapper.selectSystem(addresserid));
        return informationPageInfo;
    }


    @Override
    public ResultVO add(InformationInfo informationInfo) {
        informationInfoMapper.insert(informationInfo);
        return null;
    }

    @Override
    public ResultVO update(InformationInfo informationInfo) {
        informationInfoMapper.updateByPrimaryKey(informationInfo);
        return null;
    }

    @Override
    public List<InformationInfo> selunread() {
        return informationInfoMapper.selectUnread();
    }

}
