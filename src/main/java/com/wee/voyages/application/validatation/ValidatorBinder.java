package com.wee.voyages.application.validatation;

import com.wee.voyages.application.validatation.rule.AreaCodeBrokenRule;
import com.wee.voyages.application.validatation.rule.BrokenRule;
import com.wee.voyages.application.validatation.rule.DateBrokenRule;
import com.wee.voyages.application.validatation.rule.IdentifyingCodeBrokenRule;
import com.wee.voyages.application.validatation.validator.DefaultValidator;
import com.wee.voyages.application.validatation.validator.Validator;
import com.wee.voyages.domain.model.customer.IDCardNum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 20:11:39
 */
public class ValidatorBinder {
    private static Map<Class, Map<String, BrokenRule>> binds = new HashMap<Class, Map<String, BrokenRule>>();

    static {
        initial();
    }

    static <T extends Validatable> Validator get(T validatable) {
        return new DefaultValidator(binds.get(validatable.getClass()));
    }


    static BrokenRuleBinder bindClass(Class clazz) {
        return new BrokenRuleBinder(clazz);
    }

    static void initial() {
        BrokenRuleBinder binder = bindClass(IDCardNum.class);
        binder.add("areaCode",new AreaCodeBrokenRule());
        binder.add("birthday",new DateBrokenRule());
        binder.add("identifyCode",new IdentifyingCodeBrokenRule());
        binder.end();
    }

    private static class BrokenRuleBinder {
        private Class clazz;
        private Map<String, BrokenRule> fieldRuleMap = new HashMap<String, BrokenRule>();


        private BrokenRuleBinder(Class clazz) {
            this.clazz = clazz;
        }



        public BrokenRuleBinder add(String field,BrokenRule rule) {
            fieldRuleMap.put(field,rule);
            return this;
        }

        public void end() {
            binds.put(clazz, fieldRuleMap);
        }

    }
}
