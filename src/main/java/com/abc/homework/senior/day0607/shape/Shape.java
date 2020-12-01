package com.abc.homework.senior.day0607.shape;

import java.io.Serializable;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/6/7. 9:31 AM
 */
public abstract class Shape implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public Shape(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
