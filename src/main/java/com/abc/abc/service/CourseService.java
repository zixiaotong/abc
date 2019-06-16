package com.abc.abc.service;

import com.abc.abc.model.GogoupCourse;

/**
 * @author zishang
 * @title
 * @date 2019年2月26日下午7:05:08
 */
public interface CourseService {

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    GogoupCourse getCourseByUserId(Long userId);

}
