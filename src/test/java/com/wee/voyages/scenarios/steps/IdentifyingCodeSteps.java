package com.wee.voyages.scenarios.steps;

import org.jbehave.scenario.steps.Steps;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.Ensure;

import java.util.List;
import java.util.ArrayList;

import com.wee.voyages.application.validatation.validator.Validator;
import com.wee.voyages.application.validatation.validator.DefaultValidator;
import com.wee.voyages.application.validatation.rule.IdentifyingCodeBrokenRule;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 21:01:59
 */
public class IdentifyingCodeSteps extends Steps {
    private List<String> idcardNums;

    @Given("idcardNums are $idcardNums")
    public void idcardNumsAre(List<String> nums){
        idcardNums=new ArrayList<String>();
        idcardNums.addAll(nums);
    }

    @Then("the validity of idcardNums is $result")
    public void theValidityOfIdcardNumsIs(String result){
        for(String idcardNum:idcardNums){
            Validator<String> validator=new DefaultValidator(new IdentifyingCodeBrokenRule());
            Ensure.ensureThat(validator.isValid(idcardNum)==Boolean.parseBoolean(result));
        }
    }
}
