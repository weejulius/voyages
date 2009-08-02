package com.wee.voyages.application.validatation.rule;

/**
 * User: weejulius
 * Date: 2009-7-30
 * Time: 9:03:52
 */
public class NoSuchRequestParameter extends RuntimeException {
    public NoSuchRequestParameter(String message) {
        super(message);
    }
}
