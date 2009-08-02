package com.wee.voyages.application.validatation.rule;

/**
 * User: weejulius
 * Date: 2009-7-30
 * Time: 8:46:37
 */
public class NoSuchPersistentObject extends RuntimeException {
    public NoSuchPersistentObject() {
    }

    public NoSuchPersistentObject(String message) {
        super(message);
    }

    public NoSuchPersistentObject(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchPersistentObject(Throwable cause) {
        super(cause);
    }
}
