package com.abc.abc.service.impl;

import com.abc.abc.dao.persistence.GogoupCourseMapper;
import com.abc.abc.model.GogoupCourse;
import com.abc.abc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zishang
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private GogoupCourseMapper courseMapper;

    @Override
    public GogoupCourse getCourseByUserId(Long userId) {
        return courseMapper.selectByPrimaryKey(userId);
    }
}
