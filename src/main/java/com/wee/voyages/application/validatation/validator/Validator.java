package com.wee.voyages.application.validatation.validator;

/**
 * User: weejulius
 * Date: 2009-7-23
 * Time: 11:27:52
 */
public interface Validator<T> {    
    void validate(T entity);
    boolean isValid(T entity);
}
