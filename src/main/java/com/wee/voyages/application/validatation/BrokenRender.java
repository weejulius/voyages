package com.wee.voyages.application.validatation;

import com.wee.voyages.application.validatation.rule.BrokenRule;

import java.util.HashSet;
import java.util.Set;

/**
 * User: weejulius
 * Date: 2009-7-23
 * Time: 21:53:31
 */
public class BrokenRender<T> {
    private Set<BrokenException> exceptions = new HashSet<BrokenException>();

    void catchThrow(BrokenRule rule, T t) {
        Set<BrokenException> ruleExceptions = rule.enforce(t);
        exceptions.addAll(ruleExceptions);

    }

    void breadkWithThrow(BrokenRule rule, T t) throws BrokenException {
        Set<BrokenException> ruleExceptions = rule.enforce(t);
        if (!ruleExceptions.isEmpty()) {
            exceptions.addAll(ruleExceptions);
            throw new BrokenException("");
        }
    }

    Set<BrokenException> exceptions() {
        return exceptions;
    }


}
