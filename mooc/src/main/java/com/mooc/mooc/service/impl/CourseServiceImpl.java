package com.mooc.mooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mooc.mooc.mapper.CourseInfoMapper;
import com.mooc.mooc.mapper.StudentOfCourseMapper;
import com.mooc.mooc.model.CourseInfo;
import com.mooc.mooc.model.CourseStatistic;
import com.mooc.mooc.model.MajorStatistic;
import com.mooc.mooc.model.StudentOfCourse;
import com.mooc.mooc.service.CourseManageService;
import com.mooc.mooc.service.CourseService;
import com.mooc.mooc.util.Define;
import com.mooc.mooc.vo.CourseInfoVO;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Autowired
    private CourseManageService courseManageService;

    @Autowired
    private StudentOfCourseMapper studentOfCourseMapper;

    /**
     * @author 涂斌砚
     * 为首页提供分页查询课程列表
     * @param currPage 页号
     * @param courseInfo 检索信息 - 可为空、课程名称、课程类别、开课教师姓名等
     * @return List<CourseInfo>
     * 检索结果表，按先后顺序
     */
    @Override
    public PageInfo<CourseInfo> list(Integer currPage, Integer pageSize, CourseInfo courseInfo) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        return new PageInfo<>(courseInfoMapper.queryAll(courseInfo));
    }

    /**
     * @author 涂斌砚
     * 教师在后台页面更新课程信息
     * @param courseInfo 课程信息
     * @return
     * 成功更新：ResultVO:{code:0;msg:”更新成功” }
     * 更新失败：ResultVO:{code:1;msg:”更新失败” }【msg中应包含详细错误信息】
     */
    @Override
    public ResultVO update(CourseInfo courseInfo) {
        ResultVO resultVO=new ResultVO();
        if(courseInfo.getName()==null || courseInfo.getName().trim().length()==0){
            resultVO.setCode(1);
            resultVO.setMsg("课程名不能为空");
            return resultVO;
        }
        courseInfoMapper.updateByPrimaryKey(courseInfo);
        resultVO.setCode(0);
        resultVO.setMsg("更新成功");
        return resultVO;
    }

    /**
     * @author 朱翔鹏
     * 管理员在课程管理页面（列表形式展示系统内所有已结束状态的课程），点击某个课程，可以查看详细信息，
     * 点击删除按钮，（倒数5秒）再点击确认删除，则完成删除操作，该课程相关表记录、文件等全部从系统中删除
     * @param courseId
     * @return
     * 成功删除：ResultVO:{code:0;msg:”删除成功” }
     * 删除失败：ResultVO:{code:1;msg:”删除失败” }【msg中应包含详细错误信息】
     */
    @Override
    public ResultVO delete(Integer courseId) {
        ResultVO resultVO=new ResultVO();
        courseInfoMapper.deleteByPrimaryKey(courseId);
        resultVO.setCode(0);
        resultVO.setMsg("删除成功");
        return resultVO;
    }

    @Override
    @Transactional
    public ResultVO add(CourseInfo courseInfo) {
        ResultVO resultVO=new ResultVO(0, "");
        CourseInfo query = new CourseInfo();
        query.setName(courseInfo.getName());
        query.setTeacherName(courseInfo.getTeacherName());
        if(courseInfo.getName()==null||courseInfo.getName().trim().length()==0){
            resultVO.setCode(1);
            resultVO.setMsg("课程名不可为空");
        }
        List<CourseInfo> querylist = courseInfoMapper.queryAll(query);

        // 检查是否为重复开设课程
        querylist.forEach(course -> {
            if(course.getTeacherId().equals(courseInfo.getTeacherId()) && course.getCheckState()!=Define.COURSE_STATE_CLOSE) {
                resultVO.setCode(2);
                resultVO.setMsg("您已经开设过一门同名课程，而且课程尚未结束！");
            }
        });

        if(resultVO.getCode() != 0)
            return resultVO;

        courseInfo.setCourseState(Define.COURSE_STATE_WAIT);
        courseInfo.setCheckState(Define.CHECK_STATE_NOT_PASS);
        if(courseInfoMapper.insert(courseInfo) > 0){
            // teacher_of_course 同时也要插入数据
            courseManageService.addTeacher(courseInfo.getId(), courseInfo.getTeacherId());
            // 下面需要调用消息模块，向管理员申请开设课程审核

            resultVO.setCode(0);
            resultVO.setMsg("添加成功");
        }else{
            resultVO.setCode(3);
            resultVO.setMsg("数据添加过程中出错，请稍后重试");
        }

        return resultVO;
    }

    @Override
    public ResultVO cancel(Integer courseId) {
        ResultVO resultVO=new ResultVO();
        CourseInfo courseInfo = courseInfoMapper.selectByPrimaryKey(courseId);
        // 仅允许教师删除未开始的课程
        if(courseInfo.getCourseState()!=Define.COURSE_STATE_WAIT){
            resultVO.setCode(1);
            resultVO.setMsg("课程正在进行中或已结束，无法撤销！");
        }else {
            courseInfoMapper.deleteByPrimaryKey(courseId);
            resultVO.setCode(0);
            resultVO.setMsg("撤销成功");
        }
        return resultVO;
    }

    @Override
    public CourseInfo sel(Integer courseId) {
        return courseInfoMapper.selectByPrimaryKey(courseId);
    }

    @Override
    public CourseInfoVO selectVO(Integer courseId, Integer userId) {
        CourseInfo course = courseInfoMapper.selectByPrimaryKey(courseId);
        if(course == null)
            return new CourseInfoVO();
        CourseInfoVO courseInfoVO =  new CourseInfoVO(course);
        courseInfoVO.setRole(0);
        // 如果传进来的 userId 为 0，则默认用户为未登录状态，无需查询角色
        if(userId > 0){
            // 下面依次判断该用户是否为这门课的教师、助教、学生
            if(courseManageService.isTeacherOfCourse(courseId, userId))
                courseInfoVO.setRole(1);
            else if(courseManageService.isAssistantOfCourse(courseId, userId))
                courseInfoVO.setRole(2);
            else if(studentOfCourseMapper.count(courseId, userId)>0)
                courseInfoVO.setRole(3);
        }
        return courseInfoVO;
    }

    @Override
    public List<CourseInfo> getByTeacherId(Integer teacherId) {
        return courseInfoMapper.selectByTeacherId(teacherId);
    }

    @Override
    public List<CourseInfo> getByAssistantId(Integer assistantId) {
        return courseInfoMapper.selectByAssistantId(assistantId);
    }

    /**
     * @author朱翔鹏
     * 用户在个人主页查询自己(学生身份)所修课程
     * @param userId
     * @return
     */
    @Override
    public PageInfo<CourseInfoVO> selfList(Integer currPage,Integer pageSize,Integer userId) {
        if(currPage==null){currPage=1;}
        PageHelper.startPage(currPage, pageSize);
        List<StudentOfCourse> list=studentOfCourseMapper.selByUserId(userId);
        List<CourseInfoVO> list1=new ArrayList<CourseInfoVO>();
        for(StudentOfCourse s:list){
            CourseInfoVO courseInfoVO=new CourseInfoVO();
            CourseInfo courseInfo=this.sel(s.getCourseId());
            //设置身份为学生
            courseInfoVO.setRole(3);
            //装入VO
            courseInfoVO.setCheckState(courseInfo.getCheckState());
            courseInfoVO.setCloseTime(courseInfo.getCloseTime());
            courseInfoVO.setCourseAuthority(courseInfo.getCourseAuthority());
            courseInfoVO.setCourseState(courseInfo.getCourseState());
            courseInfoVO.setDetail(courseInfo.getDetail());
            courseInfoVO.setId(courseInfo.getId());
            courseInfoVO.setIntro(courseInfo.getIntro());
            courseInfoVO.setName(courseInfo.getName());
            courseInfoVO.setOpenTime(courseInfo.getOpenTime());
            courseInfoVO.setPhoto(courseInfo.getPhoto());
            courseInfoVO.setReference(courseInfo.getReference());
            courseInfoVO.setSchool(courseInfo.getSchool());
            courseInfoVO.setTarget(courseInfo.getTarget());
            courseInfoVO.setTeacherId(courseInfo.getTeacherId());
            courseInfoVO.setTeacherName(courseInfo.getTeacherName());
            courseInfoVO.setType(courseInfo.getType());
            list1.add(courseInfoVO);
        }
        return new PageInfo<>(list1);
    }

    /**
     * @author 朱翔鹏
     * 在数据统计功能下，管理员可以查看系统内所有课程的专业分布统计
     * @return
     * List<MajorStatistic>
     * List:用于echarts图表的数据list
     * 每个list项是一个MajorStatistic对象:{major,num}
     */
    @Override
    public List<MajorStatistic> majorRank(Integer year) {
        return courseInfoMapper.queryMajorSum(year);
    }

    @Override
    public List<CourseStatistic> courseRank(Integer year) {
        return courseInfoMapper.queryCourseSum(year);
    }

    @Override
    public List<CourseInfo> selectByCreateTime(Integer limit) {
        return courseInfoMapper.selectByCreateTime(limit);
    }

    @Override
    public List<CourseInfo> selectByMostStudentNumber(Integer limit) {
        return courseInfoMapper.selectByMostStudentNumber(limit);
    }
}
