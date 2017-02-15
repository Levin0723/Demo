package com.levin.mvcdemo.controller;

import com.levin.mvcdemo.model.Course;
import com.levin.mvcdemo.model.User;
import com.levin.mvcdemo.service.CourseService;
import com.levin.mvcdemo.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 课程controller
 * Created by 黄桂道 on 2017-2-9.
 */

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static Logger log = Logger.getLogger(CourseController.class);

    private CourseService courseService;
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    //  URL:localhost:8080/courses/view?courseId=123
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId")Integer courseId, Model model){
        log.debug("In viewCourse,RequestParam,courseId="+courseId);
        Course course = courseService.getCoursebyId(courseId);
        model.addAttribute(course);
        return "course_overview";
    }

    //  URL:localhost:8080/courses/view2/123
    @RequestMapping(value = "/view2/{courseId}",method = RequestMethod.GET)
    public String viewCourse2(@PathVariable("courseId")Integer courseId, Map<String,Object> model){
        log.debug("In viewCourse,PathVariable,courseId="+courseId);
        Course course = courseService.getCoursebyId(courseId);
        model.put("course",course);
        return "course_overview";
    }

    //  URL:localhost:8080/courses/view?courseId=123
    @RequestMapping(value = "/view3",method = RequestMethod.GET)
    public String viewCourse3(HttpServletRequest request){
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        log.debug("In viewCourse,request,courseId="+courseId);
        Course course = courseService.getCoursebyId(courseId);
        request.setAttribute("course",course);
        return "course_overview";
    }

    //添加课程
    @RequestMapping(value = "/admin",method = RequestMethod.GET,params = "add")
    public String createCourse(){
        return "course_admin/edit";
    }

    //保存课程
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String doSave(Course course){

        //数据库持久化操作
        course.setCourseId(123);
        log.debug("Info of Course");
        log.debug(ReflectionToStringBuilder.toString(course));
        return "redirect:view2/"+course.getCourseId();
    }

    //文件上传
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String showUploadPage(){
       return "course_admin/file";
    }

    //文件保存
    @RequestMapping(value = "/doUpload",method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        if (!multipartFile.isEmpty()){
            log.debug("Process File:"+multipartFile.getName());
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),
                    new File("D:\\JAVA\\GitHub\\Test02\\springMVC2\\src\\main\\webapp\\resources\\imgs\\"
                            +System.currentTimeMillis()+multipartFile.getOriginalFilename()));
        }
        return "success";
    }

    //返回JSON
    @RequestMapping(value = "/{courseId}",method = RequestMethod.GET)
    public @ResponseBody Course getCourseInJson(Integer courseId){
        return courseService.getCoursebyId(courseId);
    }

    //用户登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //用户登录结果
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request,User user){
        request.getSession().setAttribute("user",user);
        return "success";
    }

}
