package com.wee.voyages.interfaces.voyage.controller;

import com.wee.voyages.application.validatation.BrokenRuleException;

import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 21:32:45
 */
public class Controllers {

    public static MVC load(ReqAndResp reqAndResp, Model obj) {
        return new MVC(reqAndResp, obj);
    }

    public static MVC load(ReqAndResp reqAndResp, String key, Object obj) {
        return new MVC(reqAndResp, new Model(key, obj));
    }

    public static MVC load(ReqAndResp reqAndResp, Object obj) {
        return new MVC(reqAndResp, Models.add(obj));
    }

    public static MVC loadException(ReqAndResp reqAndResp, Throwable exception) {
        Model model = new Model();
        if (exception instanceof BrokenRuleException) {
            BrokenRuleException brokenRuleException = (BrokenRuleException) exception;
            installBrokenRuleExceptionToModel(brokenRuleException.ruleResults(), model);
        } else {
            model.add("exception", exception.getMessage());
        }
        return new MVC(reqAndResp, model);
    }


    private static void installBrokenRuleExceptionToModel(Map<String, String> ruleResults, Model model) {
        for (Map.Entry<String, String> ruleResult : ruleResults.entrySet()) {
            String name = ruleResult.getKey();
            String value = ruleResult.getValue();
            model.add(name + "Exception", value);
        }
    }
}
