package carInsuranceCheck.carInsuranceCheck;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},glue = {"stepDefinitions"},features = {"//src///test//resources/"},monochrome=true)
	public class TestRunnerCucumber extends AbstractTestNGCucumberTests{
		
			}
