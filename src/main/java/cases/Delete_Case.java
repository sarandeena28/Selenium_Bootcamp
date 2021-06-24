package cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Case {

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
		driver.findElementByXPath("//p[text()='Sales']/ancestor::div[@class='slds-app-launcher__tile-body slds-truncate']").click();
		driver.findElementByXPath("//span[text()='Cases Menu']/ancestor::a[@class='slds-button slds-button_reset']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='My Cases']/ancestor::a"));
		String caseDetail= driver.findElementByXPath("//table[@role='grid']//tbody//tr").getText();
		System.out.println(caseDetail);
		String caseNumber=driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a").getText();
		System.out.println(caseNumber);
		String contactName = driver.findElementByXPath("//table[@role='grid']//tbody//tr//td[3]//a").getText();
		System.out.println(contactName);
		driver.findElementByXPath("//a[contains(text(),'"+contactName+"')]/following::span[text()='Show Actions']/ancestor::a").click();
		driver.findElementByXPath("//div[text()='Delete']/parent::a").click();
		driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
//		Alert alert=driver.switchTo().alert();
//		alert.accept();
		driver.findElementByXPath("//input[@name='Case-search-input']").sendKeys(contactName,Keys.ENTER);
		String text = driver.findElementByXPath("//div[@class='listViewContent slds-table--header-fixed_container']").getText();
		if (text.equals("No records to display")) {
			System.out.println("Case not deleted");
		} else {
			System.out.println("Case deleted");
		}
	//	driver.findElementByXPath("//a[text()='"+contactName+"']/preceding::a[text()='"+caseNumber+"']");
	}

}
