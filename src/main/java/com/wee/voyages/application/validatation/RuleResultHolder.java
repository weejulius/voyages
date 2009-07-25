package com.wee.voyages.application.validatation;

import java.util.HashSet;
import java.util.Set;

/**
 * User: weejulius
 * Date: 2009-7-25
 * Time: 8:14:05
 */
public class RuleResultHolder {
    private final RuleResult success = new SuccessRuleResult();
    private Set<BrokenRuleException> brokenRuleExceptions;
    private Set<RuleException> ruleExceptions;

    public void newRuleException(String message) {
        lazyLoad(ruleExceptions).add(new RuleException(message));
    }

    public void newBrokenRuleException(String message) {
        BrokenRuleException ruleResult= new BrokenRuleException(message);
        lazyLoad(brokenRuleExceptions).add(ruleResult);
        throw ruleResult;

    }

    private Set lazyLoad(Set sets) {
        if (null == sets) {
            sets = new HashSet();
        }
        return sets;
    }

    public void throwsAll(){

    }


}
