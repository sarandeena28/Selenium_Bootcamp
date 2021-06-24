package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Edit_Case extends BaseClass{
	public String caseNumber;
	public String caseStatus;
	@When ("Click on toggle menu button from the left corner")
	public void clickToggleMenu() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}

	@Then ("Dropdown displayed")
	public void verifyDropdown() {
		System.out.println("Dropdown displayed");
	}
	@When ("Click view All") 
	public void clickViewAll() {
		driver.findElementByXPath("//button[text()='View All']").click();
	}
	@Then ("App Launcher Displayed")
	public void appLaunch() {
		System.out.println("App Launcher Displayed");
	}
	@When ("click Sales from App Launcher")
	public void clicksales() {
		driver.findElementByXPath("//p[text()='Sales']/ancestor::div[@class='slds-app-launcher__tile-body slds-truncate']").click();
	}
	@Then ("Sales Page Loaded Successfully")
	public void salesPage() {
		System.out.println("Sales Page Loaded Successfully");
	}
	@When ("Click on Cases") 
	public void clickCase() {
		driver.findElementByXPath("//span[text()='Cases Menu']/ancestor::a[@class='slds-button slds-button_reset']").click();
	}
	@Then ("Dropdown displayed in case")
	public void drowpdown() {
		System.out.println("Dropdown displayed");
	}
	@When ("Click on the My case from Dropdown") 
	public void clickMycase() {
		 js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='My Cases']/ancestor::a"));
	}
	@Then ("Case with my name Loaded")
	public void caseMyName() {
		caseStatus = driver.findElementByXPath("//table[@role='grid']//tbody//tr").getText();
		System.out.println(caseStatus);
		caseNumber = driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a").getText();
		System.out.println(caseNumber);
	}
	@When ("Click dropdown icon")
	public void clickDropdown() {
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
	}
	@When ("Click Edit")
	public void clickEdit()throws InterruptedException  {
		driver.findElementByXPath("//div[text()='Edit']/ancestor::a").click();
		Thread.sleep(2000);
	}
	@Given ("Update Status as {string}")
	public void updateStatus(String status) {
		
		 wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right']//input)[2]"))).click();
		driver.findElementByXPath("//span[text()='"+status+"']/ancestor::lightning-base-combobox-item").click();
	}
	@And ("Update Priority to {string}")
	public void updatePriority(String priority) {
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[text()='"+priority+"']").click();
	}
	@And ("Update SLA violation to {string}")
	public void updateSLA(String sla) {
		driver.findElementByXPath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='SLA Violation']/following::a").click();
		driver.findElementByXPath("//a[text()='"+sla+"']").click();
	}
	@And ("Update Case Origin as {string}")
	public void updateCaseOrigin(String caseOrigin) {
		driver.findElementByXPath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='Case Origin']/following::a").click();
		driver.findElementByXPath("//a[text()='"+caseOrigin+"']").click();	
	}
	@When ("Click on Save")
	public void clicksave() {
		driver.findElementByXPath("(//span[text()='Save'])[2]/parent::button").click();
	}
	@Then ("Verify Status as Working")
	public void verifyStatus() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr")));
		Thread.sleep(3000);
		String status = driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a[text()='"+caseNumber+"']/following::span[@class='slds-truncate']").getText();
		System.out.println(status);
	}
	


	
	

}
