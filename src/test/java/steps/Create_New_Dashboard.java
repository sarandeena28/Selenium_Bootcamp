package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create_New_Dashboard extends BaseClass {
	@When ("Click on toggle menu button left corner")
	public void clickToggleLeft() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}
	@Then ("Dropdown is displayed to select view all")
	public void verifyDropdownViewAllDisplayed() {
		System.out.println("Dropdown displayed to select view all");
	}
	@When ("Click view All in the displayed dropdown")
	public void clickViewAllLink() {
		driver.findElementByXPath("//button[text()='View All']").click();
	}
	@Then ("App Launcher window poped")
	public void verifyAppPopup() {
		System.out.println("App Launcher window poped");
	}
	@When ("Service Console from App Launch")
	public void clickServiceConsole() {
		driver.findElementByXPath("//p[text()='Service Console']/ancestor::div[@class='slds-truncate']").click();
	}
	@Then ("Service Page displayed")
	public void verifyServicePage() {
		System.out.println("Service Page displayed");
	}
	@Given ("Select Home from the DropDown")
	public void selectHome() {
		driver.findElementByXPath("//span[text()='Show Navigation Menu']/ancestor::button").click();
	}
	@And ("Select Dashboards from DropDown")
	public void selectDashboard() throws InterruptedException {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboards']/ancestor::a"))).click();
	}
	@When ("Click on New Dashboard")
	public void clickNewDashboard() {
		driver.findElementByXPath("//div[text()='New Dashboard']/parent::a").click();
//		driver.navigate().refresh();
		
	}
	@Then ("New Dashboard window displayed")
	public void verifyNewDashboard() {
		System.out.println("New Dashboard window displayed");
	}
	@Given ("Enter the Dashboard name as {string}")
	public void enterDashboardName(String dashboardName) {
		WebElement frame=driver.findElementByXPath("//iframe[@title='dashboard']");
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboardNameInput")));
		driver.findElementById("dashboardNameInput").sendKeys(dashboardName);
		 newDashboardName=driver.findElementById("dashboardNameInput").getAttribute("value");
		System.out.println(newDashboardName);
			}
	@And  ("Enter Description as {string}") 
	public void enterDescription(String description) {
		driver.findElementById("dashboardDescriptionInput").sendKeys(description);
		
	}
	@When ("Click on Create")
	public void clickCreate() {
		driver.findElementByXPath("//button[text()='Create']").click();
		
	}
	@Then ("page to click done loaded")
	public void verifyPage() throws InterruptedException {
		driver.switchTo().defaultContent();
		WebElement frame1=driver.findElementByXPath("//iframe[@title='dashboard']");
		driver.switchTo().frame(frame1);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}
	@When ("Click on Done")
	public void clickDone() {
		WebElement frame2=driver.findElementByXPath("//iframe[@title='dashboard']");
		driver.switchTo().frame(frame2);
		driver.executeScript("arguments[0].click()", driver.findElementByXPath("//button[text()='Done']"));
		driver.switchTo().defaultContent();
	}
	@Then ("Verify the Dashboard is Created")
	public void verifyNewlyCreatedDashboard() {
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
	}
	@When ("Click on Subscribe")
	public void clickSubscribe() {
		driver.findElementByXPath("//button[text()='Subscribe']").click();
		driver.switchTo().defaultContent();
	}
	@Then ("Subscribe page displayed")
	public void verifySubcribePage() {
		System.out.println("Subscribe page displayed");
	}
	@Given ("Select Frequency as 'Daily'")
	public void selectFrequency() {
		driver.findElementByXPath("//span[text()='Daily']").click();
			}
			
	@And ("Time as 10:00 AM")
	public void selectTime() {
		WebElement selectValue=driver.findElementByXPath("//select[@class=' select']");
		Select drop=new Select(selectValue);
		drop.selectByValue("10");
	}
	@When ("Click on Save in window")
	public void clickSave() {
		driver.findElementByXPath("//span[text()='Save']/parent::button").click();
	}
	@Then ("Verify 'You started Dashboard Subscription' message displayed or not")
	public void verifySubscriptionMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")));
		String verifySubscription=driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
		System.out.println(verifySubscription);
		if(verifySubscription.contains("You started a dashboard subscription")) {
			System.out.println("You started Dashboard Subscription displayed successfully");
		}
		else {
			System.out.println("Subscription Msg not displayed");
		}
	}
	@When ("Close the 'SaranyaJ30_Workout' tab")
	public void closeTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close "+newDashboardName+"']//lightning-primitive-icon"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboards']/ancestor::a"))).click();
	}
	@Then ("Dasboard page loaded")
	public void verifyDashboard() {
		System.out.println("Dasboard page loaded");
	}
	@When ("Click on Private Dashboards")
	public void clickPrivateDashboard() {
		driver.findElementByXPath("//a[text()='Private Dashboards']").click();
	}
	@Then ("Verify the newly created Dashboard available")
	public void verifyNewDashboardAvailable() {
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
	}
	
}
