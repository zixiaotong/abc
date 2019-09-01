package com.abc.abc.service.impl;

import com.abc.abc.dao.persistence.GogoupCourseMapper;
import com.abc.abc.model.GogoupCourse;
import com.abc.abc.service.CourseService;
import com.abc.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zishang
 */
@Service
public class CourseServiceImpl extends LoggerUtil implements CourseService {

    @Autowired
    private GogoupCourseMapper courseMapper;

    @Override
    public GogoupCourse getCourseByUserId(Long userId) {
        try {
            return courseMapper.selectByPrimaryKey(userId);
        } catch (Exception e) {
            this.log_error("getCourseByUserId", e);
        }
        return null;
    }
}
