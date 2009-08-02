package com.wee.voyages.application.validatation;

import java.util.regex.Pattern;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 20:20:36
 */
public class Strings {
    public static boolean nullOrBlank(String str) {
        return str == null || str.isEmpty();
    }

    public static String cutFromLast(String string, String indexWord) {
        int lastindex = string.lastIndexOf(indexWord);
        int length = string.length();
        return lastindex + 1 <= length - 1 ? string.substring(lastindex + 1) : "";
    }

    public static String[] asArray(String newParam) {
        return new String[]{newParam};
    }

    public static boolean isInt(String newParam) {
        return Pattern.matches("\\d+", newParam);
    }

    public static String deleteSlash(String str) {
        if (notNullOrBlank(str)) {
            return str.replace("/", "");
        }
        return str;
    }

    private static boolean notNullOrBlank(String str) {
        return !nullOrBlank(str);
    }

    public static String nullToBlank(String str) {
        return str==null?"":str;
    }


    public static boolean notNull(String el) {
        return null!=el;
    }

    public static boolean notBlank(String value) {
        return notNull(value)&&!"".equals(value.trim());
    }
}
