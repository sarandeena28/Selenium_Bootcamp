package order;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Order extends BaseClass{
	@BeforeTest
	public void getSheetName() {
		sheetName="Create_New_Order";
	}
	@Test(dataProvider="fetchData")
	public void editOrder()throws InterruptedException {
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
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Service Console']"))).click();
//		List<WebElement> openedWindow = driver.findElementsByXPath("//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']");
//		if(openedWindow.contains(openedWindow)) {
//		for (int i = 0; i < openedWindow.size(); i++) {
//			driver.findElementByXPath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])["+i+"]").click();
//		}
//		}else
//		{
//			driver.findElementByXPath("//span[text()='All Orders']/ancestor::a").click();
//		}
//		
		driver.findElementByXPath("//a[@title='Select List View']").click();
		driver.findElementByXPath("//span[text()='All Orders']/ancestor::a").click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//tbody//tr//td[8]//a"))).click();
		driver.findElementByXPath("//a[@title='Edit']").click();
		driver.findElementByXPath("(//a[@class='deleteAction'])[2]").click();
		driver.findElementByXPath("(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]").sendKeys("Test");
		driver.findElementByXPath("(//mark[text()='Test'])[2]/ancestor::a").click();
		driver.findElementByXPath("//a[@class='deleteAction']").click();
		driver.findElementByXPath("//div[text()='TestLeaf']/ancestor::a").click();
		driver.findElementByXPath("(//span[text()='Save']/parent::button)[3]").click();
	}

}
