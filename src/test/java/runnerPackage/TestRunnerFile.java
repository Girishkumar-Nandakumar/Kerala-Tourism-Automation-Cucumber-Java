package runnerPackage;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/FeatureFile1.feature",   // Folder where all your .feature files are stored
    glue = {"cucumberPackage1"},                 // Step definitions package (make sure it matches your actual package name)
    monochrome = true,                           // Makes console output more readable
    plugin = {
        "pretty",                                // Prints readable steps in the console
        "html:target/cucumber-reports/CucumberReport.html",  // Generates HTML report
        "json:target/cucumber-reports/CucumberReport.json",  // Generates JSON report
        "junit:target/cucumber-reports/CucumberReport.xml"   // (optional) useful for CI/CD tools
    },
    tags = "@Login"                              // Runs only scenarios tagged with @Login
)
public class TestRunnerFile {
}
