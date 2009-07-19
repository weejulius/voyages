package com.wee.voyages.domain.shared;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 16:34:37
 */
public interface Rule<T> {
    public boolean validate(T t);
}
