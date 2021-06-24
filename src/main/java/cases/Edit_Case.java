package cases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Case {

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
		driver.findElementByXPath("//a[@title='Cases']").click();
		driver.findElementByXPath("//span[text()='Cases Menu']/ancestor::a[@class='slds-button slds-button_reset']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='My Cases']/ancestor::a"));
		String caseStatus = driver.findElementByXPath("//table[@role='grid']//tbody//tr").getText();
		System.out.println(caseStatus);
		String caseNumber = driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a").getText();
		System.out.println(caseNumber);
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		driver.findElementByXPath("//div[text()='Edit']/ancestor::a").click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right']//input)[2]"))).click();
		driver.findElementByXPath("//span[text()='Working']/ancestor::lightning-base-combobox-item").click();
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[text()='Low']").click();
		driver.findElementByXPath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='Case Origin']/following::a").click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='select'])[3]"))).click();
//		driver.findElementByXPath("(//a[@class='select'])[3]").click();
		driver.findElementByXPath("//a[text()='Phone']").click();
		driver.findElementByXPath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='SLA Violation']/following::a").click();
		driver.findElementByXPath("//a[text()='No']").click();
		driver.findElementByXPath("(//span[text()='Save'])[2]/parent::button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr")));
		Thread.sleep(3000);
		String status = driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a[text()='"+caseNumber+"']/following::span[@class='slds-truncate']").getText();
		System.out.println(status);
		
		
	}

}
