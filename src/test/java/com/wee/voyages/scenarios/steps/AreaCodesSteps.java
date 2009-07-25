package com.wee.voyages.scenarios.steps;

import org.jbehave.scenario.steps.Steps;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.Ensure;
import com.wee.voyages.domain.model.customer.AreaCodes;

import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 10:54:03
 */
public class AreaCodesSteps extends Steps {
    private AreaCodes areaCodes;
    private List<String> codes;

    @Given("a code is $code")
    public void  ACodeIs(List<String> codes){
        areaCodes=AreaCodes.instance();
        this.codes=codes;
    }

    @Then("area codes has the code is $result")
    public void AreaCodesHasTheCodeIs(String result){
        for(String code:codes){
          Ensure.ensureThat(areaCodes.hasCode(code)==Boolean.parseBoolean(result));
        }        
    }
}
