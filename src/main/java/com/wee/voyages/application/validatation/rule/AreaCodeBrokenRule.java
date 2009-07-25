package com.wee.voyages.application.validatation.rule;

import com.wee.voyages.domain.model.customer.AreaCodes;
import com.wee.voyages.domain.model.customer.IDCardNum;
import com.wee.voyages.application.validatation.rule.BrokenRule;
import com.wee.voyages.application.validatation.BrokenException;

import java.util.Set;
import java.util.HashSet;

/**
 * User: weejulius
 * Date: 2009-7-23
 * Time: 22:31:52
 */
public class AreaCodeBrokenRule implements BrokenRule<IDCardNum> {
    private final Set<BrokenException> exceptions=new HashSet<BrokenException>();
    public Set<BrokenException> enforce(IDCardNum entity) {
        boolean hasCode = AreaCodes.instance().hasCode(entity.areaCode());
        if (!hasCode) {
            exceptions.add(new BrokenException("UNKNOW AREA CODE"));
        }
        return exceptions;
    }


}
