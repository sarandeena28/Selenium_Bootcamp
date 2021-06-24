package legalEntity;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Legal_Entity extends BaseClass{
	@BeforeTest
	public void getSheet() {
		sheetName="Create_Legal_Entity";
	}
	@Test(dataProvider="fetchData")
	public  void create_LegalEntity(String EntityName){
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions option=new ChromeOptions();
//		option.addArguments("--disable-notifications");
//		//option.addArguments("start-maximized");
//		ChromeDriver driver=new ChromeDriver(option);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://login.salesforce.com/");
//		driver.findElementById("username").sendKeys("cypress@testleaf.com");
//		driver.findElementById("password").sendKeys("Bootcamp@123");
//		driver.findElementById("Login").click();
//		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
//		driver.findElementByXPath("//button[text()='View All']").click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("javascript:window.scrollBy(0,500)");
//		driver.findElementByXPath("//p[text()='Legal Entities']/ancestor::li").click();
		//driver.findElementByXPath("//a[@title='Select List View']").click();
		driver.findElementByXPath("//div[text()='New']/ancestor::li").click();
		driver.findElementByXPath("//input[@class=' input']").sendKeys(EntityName);
		String entitynewName = driver.findElementByXPath("//input[@class=' input']").getAttribute("value");
		System.out.println(entitynewName);
		driver.findElementByXPath("//button[@title='Save']").click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		String createdEntityName = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
		System.out.println(createdEntityName);
		if(entitynewName.contains(createdEntityName)) {
			System.out.println("New Legal Entity Created Succesfully");
		}
		else {
			System.out.println("New Legal Entity not Created");
		}
		
		
	}

}
