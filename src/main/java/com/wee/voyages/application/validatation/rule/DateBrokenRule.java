package com.wee.voyages.application.validatation.rule;

import com.wee.voyages.application.validatation.RuleResultHolder;

import java.util.regex.Pattern;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 14:54:24
 */
public class DateBrokenRule implements BrokenRule<String> {

    private final static String LEAP_YEAR_REG = "[19|20][0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|" +
            "(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[12][0-9]))";

    private final static String NON_LEAP_YEAR_REG = "[19|20][0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|" +
            "(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|1[0-9]|2[0-8]))";

    public void enforce(String date) {
        Pattern pattern = Pattern.compile(getReg(date));
        if (!pattern.matcher(date).find()) {
            Throws.brokenRuleException("wrong birthday format");
        }
    }

    public String getReg(String date) {
        String result = NON_LEAP_YEAR_REG;
        if (isLeapYear(date)) {
            result = LEAP_YEAR_REG;
        }
        return result;
    }

    private boolean isLeapYear(String date) {
        int year = getYearOfDate(date);
        return (year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0);
    }

    private int getYearOfDate(String date) {
        validateLengthOfDate(date);
        return Integer.parseInt(date.substring(0, 4));
    }

    //TODO delete the method.
    private void validateLengthOfDate(String date) {
        boolean result = date.length() == 8;
        if (!result) {
            Throws.brokenRuleException("wrong length of date.");
        }
    }


}
