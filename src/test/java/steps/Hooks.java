package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass {
		@Before
		public void beforeScenario(Scenario sc) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver=new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://login.salesforce.com/");
			driver.findElementById("username").sendKeys("cypress@testleaf.com");
			driver.findElementById("password").sendKeys("Bootcamp@123");
			driver.findElementById("Login").click();
		}
		
//		@After
//		public void afterScenario(Scenario sc) {
////			// TODO Auto-generated method stub
////			driver.quit();
//		}
	}


