/**
 * 
 */
package com.vito16.mvc1.test;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
public class RegTest {

	@Test
	public void testZzbds() {
		String regex = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}(\\d|x|X)$";
		String str = "100222299111032434";
		assertEquals(true, str.matches(regex));
	}
}
