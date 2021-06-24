package steps;

import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_WorkType extends BaseClass {
	@When("Click toggle on left corner")
	public void click_toggle_on_left_corner() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}

	@Then("Dropdown to click view all")
	public void dropdown_to_click_view_all() {
	    System.out.println("Dropdown to click view all");
	}
	@When("Click view All in dropdown list displayed")
	public void Click_View_All_DropdownList() {
		driver.findElementByXPath("//button[text()='View All']").click();
	}
	@Then("App Launcher window will be displayed")
	public void app_launcher_window_will_be_displayed() {
	    System.out.println("App Launcher window will be displayed");
	}

	@When("Click on Work Types")
	public void click_on_work_types() {
		js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,2000)");
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Work Types']/ancestor::a"));
	}

	@Then("Work type page displayed")
	public void work_type_page_displayed() {
	   System.out.println("Work type page displayed");
	}

	@When("Click on the Arrow button at the end of the first result")
	public void click_on_the_arrow_button_at_the_end_of_the_first_result() {
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
	}

	@Then("Drop displayed to select delete")
	public void drop_displayed_to_select_delete() {
	 System.out.println("Drop displayed to select delete");  
	}

	@When("Click on Delete")
	public void click_on_delete() {
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		driver.findElementByXPath("(//a[@title='Delete'])[2]").click();
		driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
	}
	@Then ("Verify the delete message displayed")
	public void verify_The_Message() {
		String deleteMessage = driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
		System.out.println(deleteMessage);
	}

}
