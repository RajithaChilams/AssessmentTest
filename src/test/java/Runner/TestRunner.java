package Runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features"
        , glue = {"Step"},
        plugin = {
                "pretty", "json:target/FailedReports/JsonReport/report.json",
                "html:target/FailedReports/HTMLReport"},
        monochrome = true)


public class TestRunner {

}

