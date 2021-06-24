package event;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_FollowUp_Event {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.findElementByXPath("//p[text()='Content']").click();
		driver.findElementByXPath("(//span[text()='View All'])[2]").click();
		driver.findElementByXPath("//button[@class='slds-button slds-button_icon slds-button_icon-container-more']").click();
		driver.findElementByXPath("//a[@role='menuitemcheckbox']").click();
		driver.findElementByXPath("//div[@class='forceVirtualActionMarker forceVirtualAction']//a[@role='button']").click();
		driver.findElementByXPath("//a[@title='Create Follow-Up Event']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@role='none']//input)[2]").clear();
		driver.findElementByXPath("(//div[@role='none']//input)[2]").sendKeys("Meeting",Keys.ENTER);
		driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys("sara");
		driver.findElementByXPath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElementByXPath("(//a[@class='entityMenuTrigger slds-button slds-button--icon slds-shrink-none slds-m-vertical--xxx-small slds-grid slds-grid_align-center'])[3]").click();
		js.executeScript("javascript:window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']"))).click();
		driver.findElementByXPath("(//input[@class='slds-input'])[2]").clear();
		LocalDate date=LocalDate.now();
		LocalDate plusDays = date.plusDays(7);
		System.out.println(plusDays);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		String plusdate = dtf.format(plusDays);
		System.out.println(plusdate);
		driver.findElementByXPath("(//input[@class='slds-input'])[2]").sendKeys(plusdate);
		driver.findElementByXPath("(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right']//input)[3]").click();
		Thread.sleep(2000);
		js.executeScript("javascript:window.scrollBy(0,-1000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='8:00 AM']"))).click();
//		driver.findElementByXPath("//span[text()='8:00 AM']").click();
		driver.findElementByXPath("//span[text()='8:00 AM']/parent::span").click();
	}

}
