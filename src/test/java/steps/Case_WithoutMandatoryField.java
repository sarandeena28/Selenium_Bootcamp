package steps;

import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Case_WithoutMandatoryField extends BaseClass {
	public String errorMsg;
	@When ("Click on toggle menu")  
	public void clickToggle() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}
	@Then ("Dropdown displayed to select view all")
	public void verifyDropdown() {
		System.out.println("Dropdown displayed to select view all");
	}
	@When ("Click view All in dropdown")
	public void clickviewAll() {
		driver.findElementByXPath("//button[text()='View All']").click();
	}
	@Then ("App Launcher window popUp")
	public void verifyPopUp() {
		System.out.println("App Launcher window popUp");
	}
	@When ("click Sales from App Launch")
	public void clicksales() {
		driver.findElementByXPath("//p[text()='Sales']/ancestor::div[@class='slds-app-launcher__tile-body slds-truncate']").click();
	}
	@Then ("Sales Page displayed")
	public void salesPage() {
	System.out.println("Sales Page displayed");	
	}
	@When ("Click on Case")
	public void clickCase() {
		 js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='Cases']/parent::a"));
	}
	@When ("Click on New button")
	public void clickNew() {
		driver.findElementByXPath("//div[text()='New']/parent::a").click();
	}
	@Then ("New Window opened")
	public void checkNewWindow() {
	System.out.println("New Window opened");	
	}
	@Given ("Choose Contact Name as 'Naveen Elumalai'")
	public void chooseContactName() {
		driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys("Naveen");
		driver.findElementByXPath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']//a[@role='option']").click();
	}
	@And ("Select status as None")
	public void selectStatus() {
		driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[2]").click();
		driver.findElementByXPath("//span[text()='--None--']").click();
	}
	@And ("Enter Subject as Testing")
	public void enterSubject() {
		driver.findElementByXPath("(//span[text()='Subject'])[2]/following::input[@class=' input']").sendKeys("Testing");
	}
	@And ("Enter Description as Automation testing")
	public void EnterDescription() {
		driver.findElementByXPath("//textarea[@class=' textarea']").sendKeys("Automation testing");
	}
	@When ("Click Save")
	public void clickSave() {
		driver.findElementByXPath("(//span[text()='Save'])[2]/parent::button").click();
	}
	@Then ("Get the text of Error message Displayed") 
	public void getErrorMsg() {
		errorMsg = driver.findElementByXPath("//ul[@class='errorsList']//li").getText();
		System.out.println(errorMsg);
	}
	@Given ("Verify the message")
	public void verifyErrorMessage() {
		if(errorMsg.contains("These required fields must be completed: Case Origin, Status")) {
			System.out.println("Error Message Verified Successfully");
		}
		else {
			System.out.println("Error Message not found");
		}
	}
}
