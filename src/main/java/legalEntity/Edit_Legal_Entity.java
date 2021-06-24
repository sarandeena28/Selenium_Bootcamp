package legalEntity;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Legal_Entity extends BaseClass{
	@BeforeClass
	public void getSheet() {
		sheetName="Edit_Legal_Entity";
	}
	@Test(dataProvider="fetchData")
	public void edit_Legal(String EntityName,String CompanyName,String Decription) throws InterruptedException {
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
		driver.findElementByXPath("//a[@title='Select List View']/parent::div").click();
		driver.findElementByXPath("//span[text()='All Legal Entities']/ancestor::li").click();
		Thread.sleep(4000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='LegalEntity-search-input']")));
		driver.findElementByXPath("//input[@name='LegalEntity-search-input']").sendKeys(EntityName,Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Show Actions']/ancestor::a")));
//		String searchName = driver.findElementByXPath("//input[@name='LegalEntity-search-input']").getAttribute("value");
//		System.out.println(searchName);
////		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+searchName+"')]")));
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		driver.findElementByXPath("//a[@title='Edit']").click();
		driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys(CompanyName);
		driver.findElementByXPath("//textarea[@class= ' textarea']").sendKeys(Decription);
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[@title='Active']").click();
		driver.findElementByXPath("//button[@title='Save']").click();
		String getStatus = driver.findElementByXPath("//span[text()='Active']").getText();
		System.out.println(getStatus);
	}
	
	@BeforeClass
	public void asetSheet() {
		sheetName="Edit_Entity";
	}
	@Test(dataProvider="fetchData")
	public void edit_Legal(String EntityName,String CompanyName) throws InterruptedException {
		driver.findElementByXPath("//a[@title='Select List View']/parent::div").click();
		driver.findElementByXPath("//span[text()='All Legal Entities']/ancestor::li").click();
		Thread.sleep(4000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='LegalEntity-search-input']")));
		driver.findElementByXPath("//input[@name='LegalEntity-search-input']").sendKeys(EntityName,Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Show Actions']/ancestor::a")));
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		driver.findElementByXPath("//a[@title='Edit']").click();
		driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys(CompanyName);
//		driver.findElementByXPath("//textarea[@class= ' textarea']").sendKeys(Decription);
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[@title='Active']").click();
		driver.findElementByXPath("//button[@title='Save']").click();
		String getStatus = driver.findElementByXPath("//span[text()='Active']").getText();
		System.out.println(getStatus);
	}
	

}
