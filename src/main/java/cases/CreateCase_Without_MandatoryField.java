package cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCase_Without_MandatoryField {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElementByXPath("//p[text()='Sales']/ancestor::div[@class='slds-app-launcher__tile-body slds-truncate']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='Cases']/parent::a"));
		driver.findElementByXPath("//div[text()='New']/parent::a").click();
		driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys("Naveen");
		driver.findElementByXPath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']//a[@role='option']").click();
		driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[2]").click();
		driver.findElementByXPath("//span[text()='--None--']").click();
		driver.findElementByXPath("(//span[text()='Subject'])[2]/following::input[@class=' input']").sendKeys("Testing");
		driver.findElementByXPath("//textarea[@class=' textarea']").sendKeys("Automation testing");
		driver.findElementByXPath("(//span[text()='Save'])[2]/parent::button").click();
		String errorMsg = driver.findElementByXPath("//ul[@class='errorsList']//li").getText();
		System.out.println(errorMsg);
		Thread.sleep(1000);
		if(errorMsg.contains("These required fields must be completed: Case Origin, Status")) {
			System.out.println("Error Message Verified Successfully");
		}
		else {
			System.out.println("Error Message not found");
		}
	}

}
