package com.abc.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shanglei
 * @date 2019/6/4 22:14
 */
//@Controller
@RestController
public class IndexController {
    /**
     * 这里value写两个 就是可以服务于两个请求
     * RequestMapping和PostMapping不能重复使用
     * RestController 相当于Controller+ResponseBody
     *
     * 为请求的不能类型
     *
     * @GetMapping(path = {"/index4"})
     * @PostMapping(path = {"index3"})
     */
    @RequestMapping(value = {"index1", "index2"}, method = {RequestMethod.POST})

    //@GetMapping(path = {"/index4"})
    //@PostMapping(path = {"index3"})
    //@ResponseBody
    public String index() {
        return "index";
    }

    /**
     * 为请求里传的参数 占位
     *
     * PathVariable
     */
    @GetMapping(path = {"/index5/{message}"})
    public String index1(@PathVariable String message) {
        return "index" + message + "";
    }
}
