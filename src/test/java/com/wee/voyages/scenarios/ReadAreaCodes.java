package com.wee.voyages.scenarios;

import org.jbehave.scenario.PropertyBasedConfiguration;
import org.jbehave.scenario.Scenario;
import org.jbehave.scenario.parser.ClasspathScenarioDefiner;
import org.jbehave.scenario.parser.PatternScenarioParser;
import org.jbehave.scenario.parser.ScenarioDefiner;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;
import com.wee.voyages.scenarios.steps.AreaCodesSteps;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 10:50:25
 */
public class ReadAreaCodes extends Scenario {
    public ReadAreaCodes() {
        this(Thread.currentThread().getContextClassLoader());
    }

    public ReadAreaCodes(final ClassLoader classLoader) {
        super(new PropertyBasedConfiguration() {
            public ScenarioDefiner forDefiningScenarios() {
                return new ClasspathScenarioDefiner(
                        new UnderscoredCamelCaseResolver(".scenario"),
                        new PatternScenarioParser(this), classLoader);
            }
        }, new AreaCodesSteps());
    }
}
