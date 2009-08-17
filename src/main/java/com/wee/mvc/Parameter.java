package com.wee.mvc;

/**
 * User: weejulius
 * Date: 2009-7-31
 * Time: 16:32:30
 */
public class Parameter {
    private String key;
    private String value;

    public Parameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }
}
