package com.abc.abc.api.course;

import com.abc.abc.controller.BaseController;
import com.abc.abc.model.GogoupCourse;
import com.abc.abc.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zishang
 */
@Api(tags = "课程相关的接口")
@RestController
@RequestMapping(value = "/CourseApi")
public class CourseApi extends BaseController {
	@Autowired
	private CourseService courseService;
	// @Autowired
	// private CounterService counterService;

	@RequestMapping(value = "/getCourseByCourseId/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "根据课程id获取课程数据", notes = "根据课程id获取课程数据")
	@ApiImplicitParams({ // 请求参数描述
			@ApiImplicitParam(name = "id", value = "课程ID", required = true, dataTypeClass = Long.class), })
	public GogoupCourse getCourseByUserId(@PathVariable("id") Long id) {
		try {
			this.log_info("根据课程id获取课程数据-课程ID:{}", new Object[] { id });
			GogoupCourse user = courseService.getCourseByUserId(Long.valueOf(id));
			return user;
		} catch (Exception e) {
			this.log_error("getCourseByUserId", e);
		}
		return null;
	}

	@RequestMapping(value = "/getCourseByCourseIds", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ApiOperation(value = "根据课程id获取课程数据", notes = "根据课程id获取课程数据")
	@ApiImplicitParams({ // 请求参数描述
			@ApiImplicitParam(name = "id", value = "课程ID", required = true, dataTypeClass = Long.class), })
	public GogoupCourse getCourseByCourseIds() {
		GogoupCourse user = courseService.getCourseByUserId(Long.valueOf(4));
		return user;
	}
}
