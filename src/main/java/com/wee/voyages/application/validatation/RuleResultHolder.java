package com.wee.voyages.application.validatation;

/**
 * User: weejulius
 * Date: 2009-7-25
 * Time: 8:14:05
 */
public class RuleResultHolder {
    /*private List<BrokenRuleMessage> brokenRuleMessages;



    public void newBrokenRuleException(String message) {
        lazyLoad(brokenRuleMessages).addView(brokenRuleMessages);
    }

    public void newBrokenRuleException(BrokenRuleException e){
        lazyLoad(brokenRuleExceptions).addView(e);

    }

    private <T> List<T> lazyLoad(List<T> sets) {
        if (null == sets) {
            sets = new ArrayList<T>();
        }
        return sets;
    }


    //maybe null
    public List<BrokenRuleException> brokenRuleExceptions() {
        return brokenRuleExceptions;
    }


    public boolean noExceptions() {
        return Objects.noSuch(brokenRuleExceptions);
    }

    public boolean hasExceptions(){
        return !noExceptions();
    }

    public void throwsAll() {

    }

    public void merge(RuleResultHolder holder) {
        mergeBrokenRuleExceptions(holder.brokenRuleExceptions());
    }

    private void mergeBrokenRuleExceptions(List<BrokenRuleException> exceptions) {
        brokenRuleExceptions = mergeExceptions(brokenRuleExceptions, exceptions);
    }


    private <T> List<T> mergeExceptions(List<T> localExceptions, List<T> exceptions) {
        if (localExceptions == null) {
            localExceptions = exceptions;
        } else {
            localExceptions.addAll(exceptions);
        }
        return localExceptions;
    }*/



}
