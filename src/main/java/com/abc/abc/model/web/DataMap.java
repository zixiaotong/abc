package com.abc.abc.model.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program:gogoup-api
 * @author:shanglei
 * @createtime:2019-12-09 14:21
 **/
@Component
public class DataMap {
	@Value("${datamap.k}")
	private String k;
	@Value("${datamap.v}")
	private String v;

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}
}
