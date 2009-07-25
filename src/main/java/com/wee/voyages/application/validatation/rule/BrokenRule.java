package com.wee.voyages.application.validatation.rule;

import com.wee.voyages.application.validatation.RuleResultHolder;

/**
 * User: weejulius
 * Date: 2009-7-23
 * Time: 21:22:12
 */
public interface BrokenRule<T> {
    RuleResultHolder enforce(T entity);

}
