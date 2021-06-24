package sales;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_ContactForCampaign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("//p[text()='Sales']/ancestor::a").click();
		driver.findElementByXPath("//span[text()='Opportunities']/ancestor::a").click();
		driver.findElementByXPath("//span[text()='Select List View']/ancestor::a").click();
		driver.findElementByXPath("//span[text()='All Opportunities']/ancestor::a").click();
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys("Bootcamp",Keys.ENTER);
		driver.findElementByXPath("//ul[@class='slds-scrollable--y']//li//a").click();
	}

}
