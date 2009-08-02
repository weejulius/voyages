package com.wee.voyages.application.validatation.rule;

import com.wee.voyages.application.validatation.BrokenRuleException;
import com.wee.voyages.interfaces.voyage.controller.InvalidRequestURI;

import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-28
 * Time: 8:56:49
 */
public class Throws {
    public static void brokenRuleException(String message) {
        throw new BrokenRuleException(message);
    }

    public static void brokenRuleException(Map<String, String> ruleResults) {
        throw new BrokenRuleException(ruleResults);
    }


    public static void noSuchPersistentObject(String message) {
        throw new NoSuchPersistentObject(message);
    }

    public static void noSuchRequestParameter(String message) {
        throw new NoSuchRequestParameter(message);
    }

    public static void invalidRequestParameter(String message) {
        throw new InvalidRequestParameter(message);
    }

    public static void invalidRequestURI(String message) {
        throw new InvalidRequestURI(message);
    }
}
