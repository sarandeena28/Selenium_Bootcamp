package dashboard;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.messages.internal.com.google.protobuf.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_New_Dashboard extends BaseClass{

	@Test
	public void create_New_Dashboard() throws InterruptedException {
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
		driver.findElementByXPath("//p[text()='Service Console']/ancestor::div[@class='slds-truncate']").click();
		driver.findElementByXPath("//span[text()='Show Navigation Menu']/ancestor::button").click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboards']/ancestor::a"))).click();
		driver.findElementByXPath("//div[text()='New Dashboard']/parent::a").click();
		driver.navigate().refresh();
		WebElement frame=driver.findElementByXPath("//iframe[@title='dashboard']");
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame)));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		//driver.switchTo().frame(frame);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboardNameInput")));
		driver.findElementById("dashboardNameInput").sendKeys("Saranjegan01234_Workout");
//		driver.findElementByXPath("//input[@id='dashboardNameInput']").sendKeys("Saranya45_Workout");
		String newDashboardName=driver.findElementById("dashboardNameInput").getAttribute("value");
		System.out.println(newDashboardName);
		driver.findElementById("dashboardDescriptionInput").sendKeys("Testing");
		driver.findElementByXPath("//button[text()='Create']").click();
		driver.switchTo().defaultContent();
		WebElement frame1=driver.findElementByXPath("//iframe[@title='dashboard']");
		driver.switchTo().frame(frame1);
		Thread.sleep(5000);
//		String newtitle = driver.getTitle();
//		System.out.println(newtitle);
		driver.switchTo().defaultContent();
		WebElement frame2=driver.findElementByXPath("//iframe[@title='dashboard']");
		driver.switchTo().frame(frame2);
		driver.executeScript("arguments[0].click()", driver.findElementByXPath("//button[text()='Done']"));
		driver.switchTo().defaultContent();
		WebElement frame3=driver.findElementByXPath("//iframe[@title='dashboard']");
		driver.switchTo().frame(frame3);
		String verifyNewDashboard=driver.findElementByXPath("//span[@class='slds-page-header__title slds-truncate']").getText();
		System.out.println(verifyNewDashboard);
		if(verifyNewDashboard.contains(newDashboardName)) {
			System.out.println("New Dashboard Created Successfully");
		}
		else {
			System.out.println("New Dashboard not created");
		}
		driver.findElementByXPath("//button[text()='Subscribe']").click();
		driver.switchTo().defaultContent();
		//driver.findElementByXPath("//span[text()='OK']/parent::button").click();
		//driver.switchTo().defaultContent();
		driver.findElementByXPath("//span[text()='Daily']").click();
		WebElement selectValue=driver.findElementByXPath("//select[@class=' select']");
		Select drop=new Select(selectValue);
		drop.selectByValue("10");
		driver.findElementByXPath("//span[text()='Save']/parent::button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")));
		String verifySubscription=driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
		System.out.println(verifySubscription);
		if(verifySubscription.contains("You started a dashboard subscription")) {
			System.out.println("You started Dashboard Subscription displayed successfully");
		}
		else {
			System.out.println("Subscription Msg not displayed");
		}
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close "+newDashboardName+"']//lightning-primitive-icon"))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboards']/ancestor::a"))).click();
		driver.findElementByXPath("//a[text()='Private Dashboards']").click();
		driver.findElementByXPath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']").sendKeys(newDashboardName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr//a//span[@class='highlightSearchText']")));
		String verifyDashboardName = driver.findElementByXPath("//table[@role='grid']//tbody//tr//a//span[@class='highlightSearchText']").getText();
		System.out.println(verifyDashboardName);
		if(verifyDashboardName.contains(newDashboardName)) {
			System.out.println("Verified the newly created Dashboard available");
		}
		else {
			System.out.println("Newly created Dashboard not available");
		}
		
		driver.findElementByXPath("//span[@class='slds-grid slds-align_absolute-center slds-grid_align-spread']//span[text()='Show actions']/ancestor::button").click();
		driver.findElementByXPath("//span[text()='Delete']/parent::a").click();
		driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")));
		String deleteMsg = driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
		System.out.println(deleteMsg);
		if(deleteMsg.contains("Dashboard was deleted")) {
			System.out.println("Dashboard Deleted successfully");
		}
		else
		{
			System.out.println("Dashboard not Deleted");
		}
		driver.findElementByXPath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']").sendKeys(newDashboardName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='emptyMessageTitle']")));
		String verifyDeletedDashboard = driver.findElementByXPath("//span[@class='emptyMessageTitle']").getText();
		if(verifyDeletedDashboard.contains("No results found")) {
			System.out.println("Deleted item is not available under Private Dashboard folder");
		}
		else {
			System.out.println("Deleted item is available under Private Dashboard folder");
		}
	}
	

}
