package com.vito16.shop.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SeriDate extends Date {

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this);
	}
	
}
