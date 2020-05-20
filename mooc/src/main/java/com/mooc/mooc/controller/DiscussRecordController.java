package com.mooc.mooc.controller;

import com.mooc.mooc.mapper.DiscussRecordMapper;
import com.mooc.mooc.model.DiscussRecord;
import com.mooc.mooc.model.DiscussionDetail;
import com.mooc.mooc.service.DiscussRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 讨论记录（发帖相关）控制模块
 */
@RestController
@RequestMapping("/discussRecord")
public class DiscussRecordController {

    @Resource
    private DiscussRecordService discussRecordService;

    @Autowired
    private DiscussRecordMapper discussRecordMapper;

    /**
     * @author 朱翔鹏
     * 学生进入某个讨论，点击发帖，编辑帖子内容，点击发布
     * 点击某帖下的回复按钮，编辑回帖内容，点击发布，该帖帖头显示“回复xx楼”
     * @param discussRecord
     * @return
     * 成功发帖：ResultVO:{code:0;msg:”发帖成功” }
     * 发帖失败：ResultVO:{code:1;msg:”发帖失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/addRecord")
    public DiscussionDetail addRecord(@RequestBody DiscussRecord discussRecord){
        discussRecord.setDiscussState(1);
        discussRecord.setSendTime(new Date());
        discussRecord.setLastUpdateTime(new Date());
        return discussRecordService.addRecord(discussRecord);
    }

    /**
     * @author 朱翔鹏
     * 学生进入某个讨论，点击某个自己发的帖，可以编辑帖子内容，点击确认
     * @param discussRecord
     * @return
     * 成功改帖：ResultVO:{code:0;msg:”修改成功” }
     * 改帖失败：ResultVO:{code:1;msg:”修改失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/updateRecord")
    public DiscussionDetail updateRecord(@RequestBody DiscussRecord discussRecord){
        return discussRecordService.updateRecord(discussRecord);
    }

    /**
     * @author 朱翔鹏
     * 学生进入某个讨论，点击某个自己发的帖，可以删除该贴
     * 助教进入某个讨论，点击某帖，可以删除该贴（前提是该讨论管理助教）
     * 教师进入某个讨论，点击某帖，可以删除该贴（前提是该讨论管理教师）
     * 管理员进入某个讨论，点击某帖，可以删除该贴
     * @param discussRecordId
     * @return
     * 成功删帖：ResultVO:{code:0;msg:”删帖成功” }
     * 删帖失败：ResultVO:{code:1;msg:”删帖失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("/deleteRecord/{discussRecordId}")
    public DiscussionDetail deleteRecord(@PathVariable Integer discussRecordId){
        DiscussRecord discussRecord=discussRecordMapper.selectByPrimaryKey(discussRecordId);
        return discussRecordService.deleteRecord(discussRecord);
    }


}
