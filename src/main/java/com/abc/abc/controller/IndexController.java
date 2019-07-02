package com.abc.abc.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.abc.model.GogoupCourse;
import com.abc.abc.service.CourseService;
import com.abc.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author shanglei
 * @date 2019/6/4 22:14
 */
@Controller
public class IndexController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", DateUtil.timestampFormat(new Date()));
        model.put("message", "Hello, world!");
        return "welcome";
    }

    @RequestMapping("/course")
    public String user(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        GogoupCourse course = courseService.getCourseByUserId(Long.valueOf(id));
        request.setAttribute("course", course);
        return "course";
    }

    /**
     * 这里value写两个 就是可以服务于两个请求
     * RequestMapping和PostMapping不能重复使用
     * RestController 相当于Controller+ResponseBody
     * <p>
     * 为请求的不能类型
     *
     * @GetMapping(path = {"/index4"})
     * @PostMapping(path = {"index3"})
     */
    @RequestMapping(value = {"index1", "index2"}, method = {RequestMethod.POST})

    //@GetMapping(path = {"/index4"})
    //@PostMapping(path = {"index3"})
    //@ResponseBody
    public String index5() {
        return "index";
    }

    /**
     * 为请求里传的参数 占位
     * 访问时 http://localhost:8081/index5/hello
     * 返回：indexhello
     * PathVariable
     */
    @GetMapping(path = {"/index5/{message}"})
    public String index5(@PathVariable String message) {
        return "index" + message + "";
    }

    /**
     * 这样访问：http://localhost:8081/index6?message=4
     * 返回：index：4
     * 参数为空会报错：Required String parameter 'message' is not present
     *
     * @param message
     */
    @GetMapping(path = {"/index6"})
    public String index6(@RequestParam String message) {
        return "index：" + message + "";
    }

    /**
     * required = false 加false 代表参数可以为空
     * value = "m" 参数为字段为m，message不可用
     * defaultValue = "Empty" 默认不传就是Empty
     *
     * @param message
     */
    @GetMapping(path = {"/index7"})
    public String index7(@RequestParam(value = "m", required = false, defaultValue = "Empty") String message,
                         HttpServletRequest request,
                         @RequestParam(value = "age", required = false, defaultValue = "Empty") Integer age) {
        String message2 = request.getParameter("message2");
        return "index：" + message + "" + "age=" + age;
    }

    /**
     * Accept
     */
    @GetMapping(path = {"/header"})
    public String header(@RequestHeader(value = "Accept") String acceptHeader) {
        return "index：" + acceptHeader + "";
    }

    /**
     * 往ResponseEntity里写值
     *
     * @param
     */
    @GetMapping(path = {"/htmlResponseEntity"})
    public ResponseEntity<String> htmlResponseEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("a", Arrays.asList("aaa"));
        ResponseEntity entity = new ResponseEntity("aaaa", headers, HttpStatus.OK);
        return entity;
    }

}
