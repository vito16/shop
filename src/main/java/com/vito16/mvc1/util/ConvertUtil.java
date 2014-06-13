package com.vito16.mvc1.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtil {
	public static String toDateStr(Object o) throws ParseException {
		return o == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format((Date) o);
	}

	public static String toYMDStr(Object o) throws ParseException {
		return o == null ? null : new SimpleDateFormat("yyyy-MM-dd")
				.format((Date) o);
	}
}
