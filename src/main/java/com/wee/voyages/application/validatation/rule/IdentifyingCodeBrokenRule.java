package com.wee.voyages.application.validatation.rule;

import com.wee.voyages.domain.model.customer.IdentifyingCode;
import com.wee.voyages.application.validatation.rule.BrokenRule;
import com.wee.voyages.application.validatation.RuleResultHolder;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 21:10:52
 */
public class IdentifyingCodeBrokenRule implements BrokenRule<String> {
    private final RuleResultHolder ruleResults =new RuleResultHolder();

    public RuleResultHolder enforce(String entity) {
        boolean isValidCode=IdentifyingCode.instance().validateCode(entity);
        if(!isValidCode){
            ruleResults.newRuleException("wrong identifying code in the idcard num.");
        }
        return ruleResults;
    }
}
