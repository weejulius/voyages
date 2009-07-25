package com.wee.voyages.application.validatation.validator;

import com.wee.voyages.application.validatation.rule.BrokenRule;
import com.wee.voyages.application.validatation.validator.Validator;
import com.wee.voyages.application.validatation.BrokenRender;

import java.util.Set;
import java.util.HashSet;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 16:47:15
 */
public class DefaultValidator implements Validator {
    private Set<BrokenRule> rules = new HashSet<BrokenRule>();
    private BrokenRender render = new BrokenRender();

    public DefaultValidator() {
    }

    public DefaultValidator(BrokenRule rule){
        add(rule);
    }

    public boolean isValid(Object entity) {
        validate(entity);       
        return render.exceptions().size() == 0;
    }

    public void validate(Object entity) {
        for (BrokenRule rule : rules) {
            render.catchThrow(rule, entity);
        }
    }

    void add(BrokenRule rule) {
        rules.add(rule);
    }


}
