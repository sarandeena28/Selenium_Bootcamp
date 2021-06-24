package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Update_Contact extends BaseClass{
	
	@When("Click on toggle on left corner")
	public void click_on_toggle_on_left_corner() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}

	@Then("Dropdown is displayed to click view all")
	public void dropdown_is_displayed_to_click_view_all() {
	  System.out.println("Dropdown is displayed to click view all");
	}

	@When("Click view All from dropdown list")
	public void click_view_all_from_dropdown_list() {
		driver.findElementByXPath("//button[text()='View All']").click();
	}

	@Then("App Launcher window opened")
	public void app_launcher_window_opened() {
	    System.out.println("App Launcher window opened");
	}

	@When("Click on contacts from App Launch")
	public void click_on_contacts_from_app_launch() {
		 js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,1000)");
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Contacts']/ancestor::a"));
	}

	@Then("Contact Page displayed")
	public void contact_page_displayed() throws InterruptedException {
	   System.out.println("Contact Page displayed"); 
	   Thread.sleep(2000);
	}

	@Given("Get the size of contacts available and print the list")
	public void get_the_size_of_contacts_available_and_print_the_list() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='countSortedByFilteredBy']")));
		countofContacts = driver.findElementByXPath("//span[@class='countSortedByFilteredBy']").getText();
		System.out.println(countofContacts);
		countContact = Integer.parseInt(countofContacts.replaceAll("[^0-9]", ""));
		System.out.println(countContact);
		for (int i = 1; i <=countContact; i++) {
			js.executeScript("arguments[0].scrollIntoView();", driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr["+i+"]"));
			String contactList = driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr["+i+"]").getText();
			System.out.println(contactList);
			js.executeScript("arguments[0].scrollIntoView(false);", driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr["+i+"]"));
		}
	}

	@Given("search for the contact using unique name {string}")
	public void search_for_the_contact_using_unique_name(String contactName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Contact-search-input']")));
		driver.findElementByXPath("//input[@name='Contact-search-input']").sendKeys(contactName,Keys.ENTER);
	}

	@When("Click on the dropdown icon available in the unique contact")
	public void click_on_the_dropdown_icon_available_in_the_unique_contact() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Show Actions']/ancestor::a")));
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
	}

	@Then("Dropdown will be displayed")
	public void dropdown_will_be_displayed() {
	    System.out.println("Dropdown will be displayed");
	}

	@When("Click on edit")
	public void click_on_edit() {
		driver.findElementByXPath("//a[@title='Edit']").click();
	}

	@Then("Edit window will open")
	public void edit_window_will_open() {
	   System.out.println("Edit window will open");
	}

	@Given("Update Email with your personal mail id {string}")
	public void update_email_with_your_personal_mail_id(String email) {
		driver.findElementByXPath("//input[@name='Email']").sendKeys(email);
		enteredEmail = driver.findElementByXPath("//input[@name='Email']").getAttribute("value");
		System.out.println(enteredEmail);  
	}

	@Given("Update Lead Source as Partner Referral from bottom")
	public void update_lead_source_as_partner_referral_from_bottom() {
		driver.findElementByXPath("//label[text()='Lead Source']/following::input[@class='slds-input slds-combobox__input']").click();
		driver.findElementByXPath("//span[text()='Partner Referral']/ancestor::lightning-base-combobox-item").click();
	}

	@Given("Update Mailing Address with personal address {string}")
	public void update_mailing_address_with_personal_address(String address) {
		driver.findElementByXPath("//textarea[@class='slds-textarea']").sendKeys(address);
	}

	@Given("Update Level as Tertiary")
	public void update_level_as_tertiary() {
		driver.findElementByXPath("//label[text()='Level']/following::input[@class='slds-input slds-combobox__input']").click();
		driver.findElementByXPath("//span[text()='Tertiary']/ancestor::lightning-base-combobox-item").click();
	}

	@Given("Update title as Automation Testing")
	public void update_title_as_automation_testing() {
		driver.findElementByXPath("//input[@name='Title']").sendKeys("Automation Testing");
	}
	@When ("Click Save in the edit window")
	public void save_AfterEditing(){
		driver.findElementByXPath("//button[text()='Save']").click();
	}
	@Then("Verify and print Email")
	public void verify_and_print_email() {
		String verifyChange = driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
		System.out.println(verifyChange);
		String Email = driver.findElementByXPath("//table[@role='grid']//tr//td[6]//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//a").getText();
		System.out.println(Email);
		if(enteredEmail.contains(Email)) {
			System.out.println("Email Verified Successfully");
		}
		else {
			System.out.println("Email Mismatch");
		}
	}

}
