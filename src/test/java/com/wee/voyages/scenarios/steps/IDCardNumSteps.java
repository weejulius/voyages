package com.wee.voyages.scenarios.steps;

import com.wee.voyages.application.validatation.validator.IDCardNumValidator;
import com.wee.voyages.application.validatation.validator.Validator;
import com.wee.voyages.domain.model.customer.IDCardNum;
import org.jbehave.Ensure;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.steps.Steps;

import java.util.List;
import java.util.ArrayList;

/**
 * User: weejulius
 * Date: 2009-7-23
 * Time: 9:04:27
 */
public class IDCardNumSteps extends Steps {
    private List<IDCardNum> idcardNums;

    @Given("IDCardNums are $nums")
    public void aIDCardNumIs(List<String> nums) {
        idcardNums=new ArrayList<IDCardNum>();
        for (String num : nums) {
            idcardNums.add(new IDCardNum(num));
        }
    }

    @Then("the validity of IDCardNums is $result")
    public void theValidityOfIDCardNumIs(String result) {
        for (IDCardNum idcardNum : idcardNums) {
          //  Validator<IDCardNum> validator = new IDCardNumValidator<IDCardNum>();
           // Ensure.ensureThat(validator.isValid(idcardNum) == Boolean.parseBoolean(result));
        }
    }
}
