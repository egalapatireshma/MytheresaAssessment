package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
					glue = {"stepDefinitions", "appHooks"},
					monochrome = true,
					plugin = {"pretty","html:target/html_outout/reports.html", "json:target/json_output/cucumber.json", "junit:target/junit_xml/cucumber.xml"})

public class TestRunner {

}
