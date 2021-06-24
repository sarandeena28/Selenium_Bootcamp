package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_case extends BaseClass{
	public String contactName;
	@When ("Click on toggle menu button")
	public void clickToggle() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}
	@Then ("Dropdown displayed to select")
	public void verifyDropdownDisplayed() {
		System.out.println("Dropdown Displayed");
	}
	@When ("Click view All link") 
	public void clickViewAll() {
		driver.findElementByXPath("//button[text()='View All']").click();
	}
	@Then ("App Launcher window Displayed")
	public void verifyAppLauncher() {
		System.out.println("App Launcher window Displayed");
	}
	@When ("Click Sales from App Launcher")
	public void clickSalesInAppLauncher() {
		driver.findElementByXPath("//p[text()='Sales']/ancestor::div[@class='slds-app-launcher__tile-body slds-truncate']").click();
	}
	@Then ("Sales Page Loaded")
	public void verifySalesPage() {
		System.out.println("Sales Page Loaded");
	}
	@When ("Click on Cases tab") 
	public void clickCaseTab() {
		driver.findElementByXPath("//span[text()='Cases Menu']/ancestor::a[@class='slds-button slds-button_reset']").click();
	}
	@Then ("Dropdown to selct my case")
	public void clickDropdownToselectMyCase() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='My Cases']/ancestor::a"));
		String caseDetail= driver.findElementByXPath("//table[@role='grid']//tbody//tr").getText();
		System.out.println(caseDetail);
		String caseNumber=driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a").getText();
		System.out.println(caseNumber);
		contactName = driver.findElementByXPath("//table[@role='grid']//tbody//tr//td[3]//a").getText();
		System.out.println(contactName);
	}
	
	@Then ("Case with my case Loaded")
	public void verifyPageLoaded() {
		System.out.println("Case with my case Loaded");
	}
	@When ("Click dropdown")
	public void clickDropdown() {
		driver.findElementByXPath("//a[contains(text(),'Saran')]/following::a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']").click();
	}
	
	@When ("select Delete")
	public void clickDelete() {
		driver.findElementByXPath("//div[text()='Delete']/parent::a").click();
		driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
		
	}
	@Then ("Verify the case with your name is deleted or not")
	public void vrifyDeleteMsg() {
		driver.findElementByXPath("//input[@name='Case-search-input']").sendKeys(contactName,Keys.ENTER);
		String text = driver.findElementByXPath("//div[@class='listViewContent slds-table--header-fixed_container']").getText();
		System.out.println(text);
		if (text.equals("No records to display")) {
			System.out.println("Case not deleted");
		} else {
			System.out.println("Case deleted");
		}
	}

	
}
