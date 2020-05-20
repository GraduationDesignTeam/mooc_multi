package com.mooc.mooc.service;

import com.github.pagehelper.PageInfo;
import com.mooc.mooc.model.InformationInfo;
import com.mooc.mooc.vo.ResultVO;

import java.util.List;


public interface InformationService {

    List<InformationInfo> selAll();

    PageInfo<InformationInfo> selBySenderId(Integer currPage, Integer pageSize, Integer senderid);

    PageInfo<InformationInfo> selByAddresserId(Integer currPage, Integer pageSize, Integer addresserid);

    PageInfo<InformationInfo> selDiscussion(Integer currPage, Integer pageSize, Integer addresserid);

    PageInfo<InformationInfo> selSystem(Integer currPage, Integer pageSize, Integer addresserid);

    ResultVO add(InformationInfo informationInfo);

    ResultVO update(InformationInfo informationInfo);

    List<InformationInfo> selunread();
}
