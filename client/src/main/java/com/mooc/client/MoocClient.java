package com.mooc.client;

import com.mooc.model.CourseInfoVO;
import com.mooc.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 调用的子模块名
@FeignClient(name="mooc")
public interface MoocClient {
    // 调用方法的url 须为全路径
    /**
     * 查询某一门课程
     * 当用户编号为 0 时，默认为游客
     * @param courseId 课程编号
     * @param userId 用户编号
     * @return courseInfoVO
     */
    @RequestMapping("course/sel/{courseId}")
    CourseInfoVO selOne(@PathVariable Integer courseId, @RequestParam Integer userId);

    /**
     * 根据userId查询用户
     * @param userId 用户编号
     * @return UserInfo
     */
    @RequestMapping("user/sel/{userId}")
    UserInfo sel(@PathVariable Integer userId);
}
