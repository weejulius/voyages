package com.wee.voyages.application.validatation;

import java.util.HashMap;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-25
 * Time: 8:26:32
 */
public class BrokenRuleException extends RuntimeException implements RuleException {
    private Map<String, String> ruleResults = new HashMap<String, String>();


    public BrokenRuleException(Map<String, String> ruleResults) {
        this.ruleResults = ruleResults;
    }

    public BrokenRuleException(String message) {
        super(message);
    }


    public Map<String, String> ruleResults() {
        if (Objects.existSuchA(ruleResults)) {
            return ruleResults;
        } else {
            throw new NoSuchObjectException("rule results does not exist");
        }
    }
}
