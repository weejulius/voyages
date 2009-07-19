package com.wee.voyages.domain.model.voyage;

import com.wee.voyages.domain.shared.Rule;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:58:12
 */
public class OverCarryRule implements Rule<Voyage> {
    private float percent;

    public OverCarryRule(float percent) {
        this.percent = percent;
    }

    public boolean validate(Voyage voyage) {
        return voyage.customerLogs().size()<=voyage.customerLogs().size()*percent  +1;
    }
}
