package com.wee.voyages.application.validatation;

/**
 * User: weejulius
 * Date: 2009-7-27
 * Time: 12:02:57
 */
public class NoSuchObjectException extends RuntimeException {
    public NoSuchObjectException() {
    }

    public NoSuchObjectException(String message) {
        super(message);
    }
}
