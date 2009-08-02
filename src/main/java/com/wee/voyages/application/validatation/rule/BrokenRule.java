package com.wee.voyages.application.validatation.rule;

/**
 * User: weejulius
 * Date: 2009-7-23
 * Time: 21:22:12
 */
public interface BrokenRule<T> {
    void enforce(T entity);
}
