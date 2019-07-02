package com.abc.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shanglei
 * @date 2019/6/4 22:14
 */
@Controller
@RequestMapping("/event")
public class EventController {

    @RequestMapping("/2019618")
    public String crazy618(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        return "event/2019618";
    }

}
