package com.abc.abc;

import com.abc.abc.model.GogoupCourse;
import com.abc.abc.service.CourseService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-08-31 21:51
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {AbcApplication.class})
public class CourseTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void test1() {
        GogoupCourse course = courseService.getCourseByUserId(444L);
        System.out.println("course：" + JSON.toJSONString(course));
    }
}
