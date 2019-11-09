package com.abc.abc.controller;

import com.abc.abc.model.GogoupCourse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author shanglei
 * @date 2019/6/4 22:14
 */
@RestController
public class XmlController {

    /**
     * produces = MediaType.APPLICATION_XML_VALUE + jackson-dataformat-xml
	 * 可以把返回格式转换成为xml
     * @return
     */
	@GetMapping(path = { "/xml" }, produces = MediaType.APPLICATION_XML_VALUE)
	public GogoupCourse xml() {
		GogoupCourse course = new GogoupCourse();
		course.setId(1L);
		course.setName("xxx");
		return course;
	}

}
