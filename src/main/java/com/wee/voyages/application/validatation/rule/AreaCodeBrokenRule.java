package com.wee.voyages.application.validatation.rule;

import com.wee.voyages.domain.model.customer.AreaCodes;

/**
 * User: weejulius
 * Date: 2009-7-23
 * Time: 22:31:52
 */
public class AreaCodeBrokenRule implements BrokenRule<String> {

    public void enforce(String entity) {
        boolean hasCode = AreaCodes.instance().hasCode(entity);
        if (!hasCode) {
            Throws.brokenRuleException("UNKNOW AREA CODE");
        }

    }
}
