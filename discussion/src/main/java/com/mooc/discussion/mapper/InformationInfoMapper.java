package com.mooc.discussion.mapper;



import com.mooc.discussion.model.InformationInfo;

import java.util.List;

public interface InformationInfoMapper {
    int deleteByPrimaryKey(Integer informationId);

    int insert(InformationInfo record);

    InformationInfo selectByPrimaryKey(Integer informationId);

    List<InformationInfo> selectAll();

    int updateByPrimaryKey(InformationInfo record);
    List<InformationInfo> selectBySenderid(Integer senderid);

    List<InformationInfo> selectByAddresserid(Integer addresserid);
    List<InformationInfo> selectDiscussion(Integer addresserid);

    List<InformationInfo> selectSystem(Integer addresserid);

    List<InformationInfo> selectUnread();
}