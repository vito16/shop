/**
 * 
 */
package com.vito16.shop.test.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/03/14
 */
public class RegTest {

	@Test
	public void testZzbds() {
		String regex = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}(\\d|x|X)$";
		String str = "100222299111032434";
		assertEquals(true, str.matches(regex));
	}
}
