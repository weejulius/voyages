package com.wee.voyages.scenarios;

import com.wee.voyages.scenarios.steps.BirthdaySteps;
import org.jbehave.scenario.PropertyBasedConfiguration;
import org.jbehave.scenario.Scenario;
import org.jbehave.scenario.parser.ClasspathScenarioDefiner;
import org.jbehave.scenario.parser.PatternScenarioParser;
import org.jbehave.scenario.parser.ScenarioDefiner;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 16:35:30
 */
public class ValidateBirthday extends Scenario {
    public ValidateBirthday() {
        this(Thread.currentThread().getContextClassLoader());
    }

    public ValidateBirthday(final ClassLoader classLoader) {
        super(new PropertyBasedConfiguration() {
            public ScenarioDefiner forDefiningScenarios() {
                return new ClasspathScenarioDefiner(
                        new UnderscoredCamelCaseResolver(".scenario"),
                        new PatternScenarioParser(this), classLoader);
            }
        }, new BirthdaySteps());
    }
}
