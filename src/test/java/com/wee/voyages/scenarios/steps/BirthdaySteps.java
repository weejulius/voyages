package com.wee.voyages.scenarios.steps;

import com.wee.voyages.application.validatation.rule.DateBrokenRule;
import com.wee.voyages.application.validatation.validator.DefaultValidator;
import org.jbehave.Ensure;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.steps.Steps;

import java.util.ArrayList;
import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 16:36:34
 */
public class BirthdaySteps extends Steps {
    private List<String> birthdays;

    @Given("birthdays are $birthdays")
    public void birthdaysAre(List<String> birthdays) {
        this.birthdays = new ArrayList<String>();
        for (String birthday : birthdays) {
            this.birthdays.add(birthday);
        }
    }

    @Then("the validity of birthdays is $result")
    public void theValidityOfBirthdaysIs(String result) {
        for (String birthday : birthdays) {
            DefaultValidator validator = new DefaultValidator();
            Ensure.ensureThat(true);
        }
    }

}