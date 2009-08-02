package com.wee.voyages.application.validatation.validator;

import com.wee.voyages.application.validatation.BrokenRuleException;
import com.wee.voyages.application.validatation.Objects;
import com.wee.voyages.application.validatation.rule.BrokenRule;
import com.wee.voyages.application.validatation.rule.Throws;

import java.util.HashMap;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 16:47:15
 */
public class DefaultValidator implements Validator {
    private Map<String, BrokenRule> fieldRulesMap = new HashMap<String, BrokenRule>();
    private Map<String, String> ruleResults = new HashMap<String, String>();
    private boolean chain = true;

    public DefaultValidator() {
    }

    public DefaultValidator(Map<String, BrokenRule> rulesMap) {
        this.fieldRulesMap = rulesMap;
    }

    public DefaultValidator(boolean chain) {
        this.chain = chain;
    }

    public DefaultValidator(Map<String, BrokenRule> rules, boolean chain) {
        this(rules);
        this.chain = chain;
    }


    @SuppressWarnings(value = "unchecked")
    public <T> void validate(T entity) {
        try {
            validateFields(entity);
        } catch (NoSuchFieldException e) {
            Throws.brokenRuleException(e.getMessage());
        } catch (IllegalAccessException e) {
            Throws.brokenRuleException(e.getMessage());
        }
        throwRuleResult();
    }

    private <T> void validateFields(T entity)
            throws NoSuchFieldException, IllegalAccessException {

        for (Map.Entry<String, BrokenRule> fieldRules : fieldRulesMap.entrySet()) {
            String field = fieldRules.getKey();
            BrokenRule rules = fieldRules.getValue();
            Object fieldValue = Reflects.fieldValue(entity, field);
            validateField(fieldValue, field, rules);
        }
    }

    private void throwRuleResult() {
        if (Objects.existSuchA(ruleResults)) {
            Throws.brokenRuleException(ruleResults);
        }
    }


    private void addToRuleResult(String field, BrokenRuleException e) {
        ruleResults.put(field, e.getMessage());
    }

    @SuppressWarnings(value = "unchecked")
    public <T> void validateField(T field, String fieldName, BrokenRule rule) {
        try {
            rule.enforce(field);
        } catch (BrokenRuleException e) {
            addToRuleResult(fieldName, e);
        }
    }
}
