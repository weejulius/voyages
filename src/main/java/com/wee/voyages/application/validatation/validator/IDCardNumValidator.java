package com.wee.voyages.application.validatation.validator;

import com.wee.voyages.domain.model.customer.IDCardNum;
import com.wee.voyages.application.validatation.rule.AreaCodeBrokenRule;
import com.wee.voyages.application.validatation.rule.BrokenRule;
import com.wee.voyages.application.validatation.rule.DateBrokenRule;
import com.wee.voyages.application.validatation.validator.Validator;
import com.wee.voyages.application.validatation.BrokenRender;

import java.util.HashSet;
import java.util.Set;

/**
 * User: weejulius
 * Date: 2009-7-23
 * Time: 14:37:23
 */
public class IDCardNumValidator<T> implements Validator<IDCardNum> {
    private Set<BrokenRule<IDCardNum>> rules = new HashSet<BrokenRule<IDCardNum>>();
    private BrokenRender<IDCardNum> render = new BrokenRender<IDCardNum>();

    public IDCardNumValidator() {
        add(new AreaCodeBrokenRule());
        add(new DateBrokenRule());
    }

    public IDCardNumValidator(BrokenRule rule){
        add(rule);
    }

    public boolean isValid(IDCardNum entity) {
        validate(entity);
        return render.exceptions().size() == 0;
    }

    public void validate(IDCardNum entity) {
        for (BrokenRule rule : rules) {
            render.catchThrow(rule, entity);
        }
    }

    void add(BrokenRule rule) {
        rules.add(rule);
    }
}
