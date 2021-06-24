package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_Dashboard extends BaseClass {
	
	@When ("Click on toggle button left corner")
	public void clicktoggleLeft() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}
	@Then("Dropdown displayed select view all")
	public void dropdown_displayed_select_view_all() {
		System.out.println("Dropdown displayed to select view all");
	}

	@When("Click view dropdown")
	public void click_view_dropdown() {
		driver.findElementByXPath("//button[text()='View All']").click();
	}

	@Then("App Launcher popup displayed")
	public void app_launcher_popup_displayed() {
		System.out.println("App Launcher window poped");
	}

	@When("Select Service Console from App Launch")
	public void select_service_console_from_app_launch() {
		driver.findElementByXPath("//p[text()='Service Console']/ancestor::div[@class='slds-truncate']").click();
	}

	@Then("Service Page should be displayed")
	public void service_page_should_be_displayed() {
		System.out.println("Service Page displayed");
	}

	@When("Click dropdown for the item in left corner")
	public void click_dropdown_for_the_item_in_left_corner() {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboards']/ancestor::a"))).click();
		driver.findElementByXPath("//span[@class='slds-grid slds-align_absolute-center slds-grid_align-spread']//span[text()='Show actions']/ancestor::button").click();
	}
	@Then ("Dropdown displayed below")
	public void dropdownDisplayed_Below() {
		System.out.println("Dropdown displayed");
	}
	@Given("Click Delete")
	public void click_delete() {
		driver.findElementByXPath("//span[text()='Delete']/parent::a").click();
	}

	@Then("Confirm the Delete")
	public void confirm_the_delete() {
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
	}
	
	@Then("Verify the item is not available under Private Dashboard folder")
	public void verify_the_item_is_not_available_under_private_dashboard_folder() {
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
