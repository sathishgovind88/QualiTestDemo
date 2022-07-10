package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src/test/resources/Feature/"},
		glue = {"stepDefinitions"},
		plugin = {"html:target/cucumber-reports/"},
		strict = true		
		)

public class UItestrun{
	
}