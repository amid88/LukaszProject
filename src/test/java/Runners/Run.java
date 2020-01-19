package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/Scenario1.feature"},
        glue = {"src.test.java.TestingSteps"},
        plugin = {"html:target/cukes", "json:target/cucumber-template-report.json",
                "junit:target/cucumber-template-report.xml",
                "pretty"},
        strict = true,
        tags = {"@test"}
)

public class Run {

}
