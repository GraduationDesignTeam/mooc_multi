package com.mooc.mooc.vo;

import com.mooc.mooc.model.DiscussRecord;
import com.mooc.mooc.model.DiscussionInfo;
import lombok.Data;

import java.util.List;

/**
 * @author 朱翔鹏
 * 封装了讨论对象的展示层
 */
@Data
public class DiscussionVO {

    //讨论区对象
    private DiscussionInfo discussionInfo;

    //该讨论区下的回帖表
    private List<DiscussRecord> list;

    public DiscussionInfo getDiscussionInfo() {
        return discussionInfo;
    }

    public void setDiscussionInfo(DiscussionInfo discussionInfo) {
        this.discussionInfo = discussionInfo;
    }

    public List<DiscussRecord> getList() {
        return list;
    }

    public void setList(List<DiscussRecord> list) {
        this.list = list;
    }
}
