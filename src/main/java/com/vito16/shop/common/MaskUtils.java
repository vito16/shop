package com.vito16.shop.common;

import java.util.Arrays;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/12/15
 */
public class MaskUtils {

    public static final char SEPARATOR_CHAR_ASTERISK = '*';
    public static final String ALL_ASTERISK = "******";

    /**
     * 把字符串mask
     * @param str 字符串
     * @return mask后的字符串
     */
    public static String mask(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return str;
        }
        if (len == 1) {
            return String.valueOf(SEPARATOR_CHAR_ASTERISK);
        }
        int maskLen;
        int begin;

            len = str.length();
            maskLen = Math.max((len) / 2, 1);
            begin = (len - maskLen) / 2;
        return mask(str, begin, begin + maskLen);
    }

    /**
     * 掩码中间几位为
     *
     * @param str
     * @param len
     * @return
     */
    public static String mask(String str, int len) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (len >= str.length()) {
            char[] mask = repeatAsterisk(str.length());
            return new String(mask);
        }
        int startIndex = (str.length() - len) / 2;
        return mask(str, startIndex, startIndex + len);
    }

    /**
     * 掩码指定的位数为*
     * <p/>
     * 注意:index从0开始
     *
     * @param str 原字符串
     * @param beginIndex 开始index,从0开始
     * @param endIndex 结束index,掩码不包括此位
     * @return 返回掩码后的字符串
     */
    public static String mask(String str, int beginIndex, int endIndex) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return String.valueOf(SEPARATOR_CHAR_ASTERISK);
        }

        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > str.length()) {
            endIndex = str.length();
        }
        int subLen = endIndex - beginIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }

        //复制整个str
        char[] chars = str.toCharArray();
        char[] mask = repeatAsterisk(subLen);
        //复制mask
        System.arraycopy(mask, 0, chars, beginIndex, subLen);
        //复制输出
        return new String(chars);
    }

    public static String maskAll(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return ALL_ASTERISK;
    }

    protected static char[] repeatAsterisk(int len) {
        char[] chars = new char[len];
        Arrays.fill(chars, MaskUtils.SEPARATOR_CHAR_ASTERISK);
        return chars;
    }

}
