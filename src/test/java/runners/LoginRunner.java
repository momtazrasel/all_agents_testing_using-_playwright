package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Login.feature", // Path to the Login feature file
        glue = {"stepDefinitions"},                              // Path to step definitions
        plugin = {"pretty", "html:target/cucumber-reports/Login.html",
                "json:target/cucumber-reports/Login.json"},
        monochrome = true,
        dryRun = false
)
public class LoginRunner {
}
