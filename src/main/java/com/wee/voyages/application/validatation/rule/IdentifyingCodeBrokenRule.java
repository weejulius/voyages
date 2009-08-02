package com.wee.voyages.application.validatation.rule;

import com.wee.voyages.domain.model.customer.IdentifyingCode;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 21:10:52
 */
public class IdentifyingCodeBrokenRule implements BrokenRule<String> {
    public void enforce(String entity) {
        boolean isValidCode = IdentifyingCode.instance().validateCode(entity);
        if (!isValidCode) {
            Throws.brokenRuleException("wrong identifying code in the idcard num.");
        }
    }
}
