package carInsuranceCheck.carInsuranceCheck;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")
public class StepDefinitions extends BaseTest{

	@Given("^User Invoke browser$")
	public void InvokeBrowser() {
		init();
		openBrowser();
	}
	
	@And("^User naviate to appliction url$")
	public void fnUserNaviation_url() {		
		
		openApplicatinUrl();
	}
	
	@Given("^User enter registration number \"([^\"]*)\"$")
    public void Enter_Registartion_ForSearch(String regNo) {
		
		driver.findElement(By.xpath("//input[@id='vehicleReg']")).clear();
		enterValueXpath("vehicleEntry_xpath",regNo);
		
    }

	@Then("^Click on the Search button$")
	public void Click_on_SearchButton() {
		clickElementXpath("SearchButton_xpath");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^Verify the car reistration \"([^\"]*)\"$")
	public void Verify_ReistrationNumber(String verificationMessage) {
		String verifyMessae = driver.findElement(By.xpath("//div[@class='result']")).getText();
		Assert.assertTrue("Car Registration is not present in application", verifyMessae.contains(verificationMessage));	
		
	}		
	
}
