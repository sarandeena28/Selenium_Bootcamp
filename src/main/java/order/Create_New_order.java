package order;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_New_order extends BaseClass {
	@BeforeTest
	public void getSheetName() {
		sheetName="Create_New_Order";
	}
	@Test(dataProvider="fetchData")
	public void createNewOrder() {
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
		driver.findElementByXPath("//a[@title='Home']").click();
		driver.findElementByXPath("//span[text()='Show Navigation Menu']/parent::button").click();
		driver.findElementByXPath("//span[text()='Orders']/ancestor::a").click();
		driver.findElementByXPath("//a[@title='Select List View']").click();
		driver.findElementByXPath("//span[text()='All Orders']/ancestor::a").click();
		driver.findElementByXPath("//div[text()='New']/ancestor::a").click();
		driver.findElementByXPath("//span[text()='New Order']/parent::a").click();
		driver.findElementByXPath("//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys("0000010");
		driver.findElementByXPath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']//a").click();
		driver.findElementByXPath("(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]").sendKeys("Test");
		driver.findElementByXPath("(//mark[text()='Test'])[2]/ancestor::a").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='select'])[2]"))).click();
		driver.findElementByXPath("//a[@title='Activated']").click();
		LocalDate date=LocalDate.now();
		LocalDate plusDays = date.plusDays(11);
		System.out.println(plusDays);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String nextMonth = dtf.format(plusDays);
		driver.findElementByXPath("//div[@class='form-element']//input").sendKeys(nextMonth);
		//driver.findElementByXPath("//button[@class='slds-button slds-button--neutral uiButton--neutral uiButton forceActionButton']").click();
		driver.findElementByXPath("(//span[text()='Save']/parent::button)[3]").click();
		
		
		
		
	}

}
