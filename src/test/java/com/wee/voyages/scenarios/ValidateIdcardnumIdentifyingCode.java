package com.wee.voyages.scenarios;

import org.jbehave.scenario.Scenario;
import org.jbehave.scenario.PropertyBasedConfiguration;
import org.jbehave.scenario.parser.ScenarioDefiner;
import org.jbehave.scenario.parser.ClasspathScenarioDefiner;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;
import org.jbehave.scenario.parser.PatternScenarioParser;
import com.wee.voyages.scenarios.steps.BirthdaySteps;
import com.wee.voyages.scenarios.steps.IdentifyingCodeSteps;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 20:59:38
 */
public class ValidateIdcardnumIdentifyingCode extends Scenario {
    public ValidateIdcardnumIdentifyingCode() {
        this(Thread.currentThread().getContextClassLoader());
    }

    public ValidateIdcardnumIdentifyingCode(final ClassLoader classLoader) {
        super(new PropertyBasedConfiguration() {
            public ScenarioDefiner forDefiningScenarios() {
                return new ClasspathScenarioDefiner(
                        new UnderscoredCamelCaseResolver(".scenario"),
                        new PatternScenarioParser(this), classLoader);
            }
        }, new IdentifyingCodeSteps());
    }
}
