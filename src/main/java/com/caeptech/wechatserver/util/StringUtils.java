package com.caeptech.wechatserver.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StringUtils {

	public static boolean isNull(String str) {
		return str == null || str.trim().length() == 0;
	}


	public static String toBlankIfNull(String value) {
		if (value == null)
			return "";
		return value;
	}

	public static/* int */long getUnixTimestamp() {
		//
		// return Math.round(new java.util.Date().getTime() / 1000);
		return System.currentTimeMillis() / 1000L;
	}

	public static String getCurrentDateTimeMS() {
		final Calendar cal = new GregorianCalendar();
		final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return df.format(cal.getTime());
	}

	public static long toLong(String s) {
		if (isNull(s))
			return 0;
		//
		try {
			DecimalFormat df = new DecimalFormat();
			return df.parse(s).longValue();
		} catch (Throwable e) {
			return 0;
		}
	}

	public static String toHexString(byte[] b) {
		//
		String retStr = "";
		String tmpStr;
		for (int i = 0; i < b.length; i++) {
			tmpStr = (Integer.toHexString(b[i] & 0xFF));
			if (tmpStr.length() == 1) {
				retStr += "0";
			}
			retStr += tmpStr;
		}
		return retStr;
	}

}
