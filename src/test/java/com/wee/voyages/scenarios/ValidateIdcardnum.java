package com.wee.voyages.scenarios;

import com.wee.voyages.scenarios.steps.IDCardNumSteps;
import org.jbehave.scenario.JUnitScenario;
import org.jbehave.scenario.PropertyBasedConfiguration;
import org.jbehave.scenario.parser.ClasspathScenarioDefiner;
import org.jbehave.scenario.parser.PatternScenarioParser;
import org.jbehave.scenario.parser.ScenarioDefiner;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;

/**
 * User: weejulius
 * Date: 2009-7-22
 * Time: 11:13:33
 */

public class ValidateIdcardnum extends JUnitScenario {
    public ValidateIdcardnum() {
        this(Thread.currentThread().getContextClassLoader());
    }

    public ValidateIdcardnum(final ClassLoader classLoader) {
        super(new PropertyBasedConfiguration() {
            public ScenarioDefiner forDefiningScenarios() {
                return new ClasspathScenarioDefiner(
                        new UnderscoredCamelCaseResolver(".scenario"),
                        new PatternScenarioParser(this), classLoader);
            }
        }, new IDCardNumSteps());
    }
}
