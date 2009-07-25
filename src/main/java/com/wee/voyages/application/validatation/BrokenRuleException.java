package com.wee.voyages.application.validatation;

/**
 * User: weejulius
 * Date: 2009-7-25
 * Time: 8:26:32
 */
public class BrokenRuleException extends RuntimeException implements RuleResult{
    public BrokenRuleException(String message) {
        
    }
}
