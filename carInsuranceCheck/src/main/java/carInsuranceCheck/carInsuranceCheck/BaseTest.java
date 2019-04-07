package carInsuranceCheck.carInsuranceCheck;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop= new Properties();
	public String bType;
	
	
	public void init()
	{
		
		try 
			{
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//projectconfig.properties");
				prop.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void openBrowser(){
		bType = prop.getProperty("appBrowser");
		if(bType.equals("Mozilla"))
			driver=new FirefoxDriver();
		else if(bType.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver_exe"));
			driver=new org.openqa.selenium.chrome.ChromeDriver();
		}
		else if (bType.equals("IE")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("iedriver_exe"));
			driver= new org.openqa.selenium.ie.InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public void openApplicatinUrl()
	{
		driver.get(prop.getProperty("appurl"));
	}
	
	public void clickElementXpath(String strXpath)
	{
		driver.findElement(By.xpath(prop.getProperty(strXpath))).click();
	}
	
	public void enterValueXpath(String strXpath,String strValue)
	{
		driver.findElement(By.xpath(prop.getProperty(strXpath))).sendKeys(strValue);
	}
}
