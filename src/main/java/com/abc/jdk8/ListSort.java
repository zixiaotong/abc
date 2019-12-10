package com.abc.jdk8;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-10-10 19:13
 **/
public class ListSort {
	public static void main(String[] args) {
		List<Long> idListSort = Arrays.asList(0L, 3L, 2L, 1L);
		// 正序
		idListSort.sort(Comparator.naturalOrder());

		String s = StringUtils.join(idListSort.toArray(), ",");
		System.out.println(s);

		String ids = StringUtils.join(idListSort.toArray(), ",");
		// System.out.println(ids);
		// 逆序
		idListSort.sort(Comparator.reverseOrder());
		// System.out.println(idListSort);

		// // 按照直播开始时间做了从小到大的排序
		// Collections.sort(appIndexCourseLives,
		// Comparator.comparing(AppIndexCourseLive::getBeiginTime));
	}
}
