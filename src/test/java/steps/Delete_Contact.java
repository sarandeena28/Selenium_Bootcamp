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

public class Delete_Contact extends BaseClass {

	@When("Click on toggle left corner of the page")
	public void click_on_toggle_left_corner_of_the_page() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}

	@Then("Dropdown to view click view all")
	public void dropdown_to_view_click_view_all() {
		System.out.println("Dropdown is displayed to click view all");
	}

	@When("Click view All in dropdown list")
	public void click_view_all_in_dropdown_list() {
		driver.findElementByXPath("//button[text()='View All']").click();
	}

	@Then("App Launcher window available")
	public void app_launcher_window_available() {
		System.out.println("App Launcher window opened");
	}

	@When("Click on contacts in App Launch window")
	public void click_on_contacts_in_app_launch_window() {
		js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,1000)");
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Contacts']/ancestor::a"));
	}

	@Then("Contact Page loaded")
	public void contact_page_loaded() {
		System.out.println("Contact Page displayed"); 
	}

	@Given("print the size of contacts available and print the list")
	public void print_the_size_of_contacts_available_and_print_the_list() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(500));
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

	@Given("search for contact using unique name {string}")
	public void search_for_contact_using_unique_name(String contactNameToDelete) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Contact-search-input']")));
		driver.findElementByXPath("//input[@name='Contact-search-input']").sendKeys(contactNameToDelete,Keys.ENTER);
	}

	@Given("Get the text of Contact name and store it")
	public void get_the_text_of_contact_name_and_store_it() throws InterruptedException {
		Thread.sleep(2000);
		contactName = driver.findElementByXPath("//a[@data-refid='recordId']").getText();
		System.out.println(contactName);
	}

	@When("Click on the dropdown icon in the unique contact")
	public void click_on_the_dropdown_icon_in_the_unique_contact() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Show Actions']/ancestor::a")));
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		
	}

	@Then("Dropdown will be appear")
	public void dropdown_will_be_appear() {
		System.out.println("Dropdown will be appear");
	}
	@When ("Click Delete to delete Contact")
	public void Click_ToDelete_Contact() {
		driver.findElementByXPath("//a[@title='Delete']").click();
		driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
		String deleteMsg = driver.findElementByXPath("//span[@data-aura-class='forceActionsText']").getText();
		System.out.println(deleteMsg);
	}
	@Then("Verify whether the Contact is Deleted")
	public void verify_whether_the_contact_is_deleted() {
		driver.findElementByXPath("//input[@name='Contact-search-input']").sendKeys(contactName,Keys.ENTER);
		String contactDeleted = driver.findElementByXPath("//div[@class='emptyContentInner slds-text-align_center']//p").getText();
		if(contactDeleted.contains(contactName)) {
			System.out.println("Contact Not Deleted");
		}
		else {
			System.out.println("Contact Deleted Successfully");
		}
		
	}

}
