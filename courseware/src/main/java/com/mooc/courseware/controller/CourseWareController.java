package com.mooc.courseware.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mooc.courseware.model.CourseWare;
import com.mooc.courseware.service.CourseWareService;
import com.mooc.courseware.util.Define;
import com.mooc.courseware.util.FileHelper;
import com.mooc.courseware.vo.CourseWareVO;
import com.mooc.courseware.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 课件控制器
 * 用于上传课件、更新课件、删除课件、获取课件等
 */
@RestController
@RequestMapping("/course_ware")
public class CourseWareController {
    @Autowired
    private CourseWareService courseWareService;
    @Value("${web.course-ware-upload-path}")
    private String courseWarePath;

    /**
     * 添加课件
     * @param courseWare 课件信息
     * @return 是否成功
     */
    @RequestMapping("/add")
    public ResultVO add(@RequestBody CourseWare courseWare){
        return courseWareService.add(courseWare);
    }

    /**
     * 更新课件
     * @param courseWare 课件信息
     * @return 是否成功
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody CourseWare courseWare){
        return courseWareService.update(courseWare);
    }

    /**
     * 删除课件
     * @param id 课件编号
     * @return 是否成功
     */
    @RequestMapping("/del/{id}")
    public ResultVO del(@PathVariable Integer id){
        return courseWareService.delete(id);
    }

    /**
     * 删除文件（可用于添加课件页面）
     * @param name 文件名
     */
    @RequestMapping("/remove/{name}")
    public void del(@PathVariable String name){
        FileHelper.delete(courseWarePath, name);
    }

    /**
     * 根据小节编号获取课件列表
     * @param sectionId 小节编号
     * @return 课件列表
     */
    @RequestMapping("/selectBySectionId/{currPage}")
    public PageInfo<CourseWareVO> selectBySectionId(@PathVariable Integer currPage, @RequestParam Integer sectionId){
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        return new PageInfo<>(courseWareService.selectBySectionId(sectionId));
    }

    /**
     * 根据课程编号获取课件列表
     * @param courseId 课程编号
     * @return 课件列表
     */
    @RequestMapping("/selectByCourseId/{currPage}")
    public PageInfo<CourseWareVO> selectByCourseId(@PathVariable Integer currPage, @RequestParam Integer courseId){
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        return new PageInfo<>(courseWareService.selectByCourseId(courseId));
    }

    /**
     * 根据课程编号获取未关联到小节的课件列表
     * @param courseId 课程编号
     * @return 课件列表
     */
    @RequestMapping("/selectUnassociatedByCourseId/{currPage}")
    public PageInfo<CourseWareVO> selectUnassociatedByCourseId(@PathVariable Integer currPage, @RequestParam Integer courseId){
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        return new PageInfo<>(courseWareService.selectUnassociatedByCourseId(courseId));
    }

    /**
     * 下载课件
     * @param originName 原文件名（用于查找原始文件）
     * @param newName 新文件名（用户下载后保存到用户端的文件名）
     * @param response http请求应答实体
     */
    @GetMapping("/download/{originName:.+}")
    public void downloadFile(@PathVariable String originName, @RequestParam String newName, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream out = null;
        response.setContentType("application/x-msdownload");
        try {
            Resource resource = FileHelper.loadFileAsResource(courseWarePath, originName);
            if(resource == null)
                return;
            inputStream = resource.getInputStream();
            //1.设置文件ContentType类型
            response.setContentType("application/octet-stream;charset=UTF-8");
            out = response.getOutputStream();
            //2.文件名从 UTF-8 转码成 windows 端可辨认的 ISO-8859-1编码
            String convertName = new String(newName.getBytes("UTF-8"), "ISO-8859-1");
            //3.设置Content-Disposition
            response.setHeader("Content-Disposition", "attachment; filename=" + convertName);
            int b = 0;
            byte[] buffer = new byte[2048];
            while (b != -1) {
                b = inputStream.read(buffer);
                if (b != -1) {
                    out.write(buffer, 0, b);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { // 操作结束后关闭输入流、输出流
                inputStream.close();
                out.close();
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
