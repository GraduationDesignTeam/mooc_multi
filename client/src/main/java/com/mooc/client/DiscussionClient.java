package com.mooc.client;


import com.github.pagehelper.PageInfo;
import com.mooc.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="discussion")
public interface DiscussionClient {

    /**
     * @author 朱翔鹏
     * 教师在所教课程页面下，讨论区功能中，点击创建新讨论，填写表单，传入后台，调用此接口
     * @param discussionInfo
     * @return
     * 成功创建：ResultVO:{code:0;msg:”创建成功” }
     * 创建失败：ResultVO:{code:1;msg:”创建失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("discussion/create")
    ResultVO create(@RequestBody DiscussionInfo discussionInfo);

    /**
     * @author 朱翔鹏
     * 教师在所教课程页面下，讨论区功能中，进入讨论区管理页面（列表形式展示所有该教师创建的讨论），
     * 可以选择某个讨论，编辑其详细信息
     * @param discussionInfo
     * @return
     * 成功修改：ResultVO:{code:0;msg:”修改成功” }
     * 修改失败：ResultVO:{code:1;msg:”修改失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("discussion/update")
    public DiscussionDetail update(@RequestBody DiscussionInfo discussionInfo);

    /**
     * @author 朱翔鹏
     * 教师在所教课程页面下，讨论区功能中，进入讨论区管理页面（列表形式展示所有该教师创建的讨论），
     * 可以删除某个讨论
     * @param discussionId
     * @return
     * 成功删除：ResultVO:{code:0;msg:”删除成功” }
     * 删除失败：ResultVO:{code:1;msg:”删除失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("discussion/delete/{discussionId}")
    public ResultVO delete(@PathVariable Integer discussionId);

    /**
     * @author 朱翔鹏
     * 用户可以设置查询条件，检索所有开设中的讨论，
     * 列表显示结果，点击某讨论，则进入该讨论页面
     * @param courseId
     * @param
     * @return
     * List<DiscussionInfo>:返回所有符合条件的讨论；若查询结果为空，则list为null
     */
    @RequestMapping("discussion/searchNew/{currPage}")
    public PageInfo<DiscussionDetail> searchNew(@PathVariable Integer currPage, @RequestBody DiscussionDetail discussionDetail);

    @RequestMapping("discussion/searchHot/{currPage}")
    public PageInfo<DiscussionDetail> searchHot(@PathVariable Integer currPage, @RequestBody DiscussionDetail discussionDetail);

    /**
     * @author 朱翔鹏
     * 用户进入某讨论，显示讨论各项信息，以及回帖
     * @param discussionId
     * @return
     * DiscussionVO:{DiscussionInfo discussionInfo;List<DiscussRecord> list}
     * DiscussionInfo:该讨论信息，名称、创建教师、描述、关闭时间
     * List<DiscussRecord>:返回所有该讨论下所发的帖子；若查询结果为空，则list为null
     */
    @RequestMapping("discussion/open/{discussionId}")
    public DiscussionDetail open(@PathVariable Integer discussionId, @RequestBody CurrPageObject currPageObject);

    /**
     * @author 朱翔鹏
     * 在数据统计功能下，管理员可以查看系统内讨论区的热度实时排行榜
     * （后续开发考虑使用某种形象的echart来展现）；并选择是否将其发布在门户网站中
     * @param year
     * @return
     */
    @RequestMapping("discussion/majorRank/{year}")
    public List<MajorStatistic> majorRank(@PathVariable Integer year);

    @RequestMapping("discussion/discussionRank/{year}")
    public List<DiscussionStatistic> discussionRank(@PathVariable Integer year);

    /**
     * @author 朱翔鹏
     * 用户查看自己所参与的讨论（有发帖记录）
     * 列表显示结果，点击某讨论，则进入该讨论页面
     * @param courseId
     * @param
     * @return
     * List<DiscussionInfo>:返回所有符合条件的讨论；若查询结果为空，则list为null
     */
    @RequestMapping("discussion/searchSelf/{currPage}")
    public PageInfo<DiscussionDetail> searchSelf(@PathVariable Integer currPage, @RequestBody UserInfo userInfo);

    @RequestMapping("discussion/openOne/{discussionId}")
    public DiscussionDetail openOne(@PathVariable Integer discussionId);

    /**
     * @author 朱翔鹏
     * 学生进入某个讨论，点击发帖，编辑帖子内容，点击发布
     * 点击某帖下的回复按钮，编辑回帖内容，点击发布，该帖帖头显示“回复xx楼”
     * @param discussRecord
     * @return
     * 成功发帖：ResultVO:{code:0;msg:”发帖成功” }
     * 发帖失败：ResultVO:{code:1;msg:”发帖失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("discussRecord/addRecord")
    public DiscussionDetail addRecord(@RequestBody DiscussRecord discussRecord);

    /**
     * @author 朱翔鹏
     * 学生进入某个讨论，点击某个自己发的帖，可以编辑帖子内容，点击确认
     * @param discussRecord
     * @return
     * 成功改帖：ResultVO:{code:0;msg:”修改成功” }
     * 改帖失败：ResultVO:{code:1;msg:”修改失败” }【msg中应包含详细错误信息】
     */
    @RequestMapping("discussRecord/updateRecord")
    public DiscussionDetail updateRecord(@RequestBody DiscussRecord discussRecord);

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
    @RequestMapping("discussRecord/deleteRecord/{discussRecordId}")
    public DiscussionDetail deleteRecord(@PathVariable Integer discussRecordId);
}
