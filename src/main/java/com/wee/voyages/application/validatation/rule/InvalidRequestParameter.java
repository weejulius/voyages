package com.wee.voyages.application.validatation.rule;

/**
 * User: weejulius
 * Date: 2009-7-30
 * Time: 9:13:11
 */
public class InvalidRequestParameter extends RuntimeException {
    public InvalidRequestParameter(String message) {
        super(message);
    }
}
