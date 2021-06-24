package steps;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cancel_Service_Appointment extends BaseClass {
	@When("Click on the App Launcher Icon left to click view all")
	public void click_on_the_app_launcher_icon_left_to_click_view_all() {
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	}

	@Then("Dropdown displayed to click view all from dropdown")
	public void dropdown_displayed_to_click_view_all_from_dropdown() {
	  System.out.println("Dropdown displayed to click view all from dropdown");
	}

	@When("Click on View All from dropdown")
	public void click_on_view_all_from_dropdown() {
		driver.findElementByXPath("//button[text()='View All']").click();
		
	}

	@Then("App launcher window opened to select Service Appointments")
	public void app_launcher_window_opened_to_select_service_appointments() {
	  System.out.println("App launcher window opened to select Service Appointments");
	}

	@When("Click on Service Appointments")
	public void click_on_service_appointments() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,1000)");
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//p[text()='Service Appointments']/ancestor::a"));
		
	}

	@Then("Service Appointments window displayed")
	public void service_appointments_window_displayed() {
	  System.out.println("Service Appointments window displayed");
	}

	@When("Click on the Dropdown Option on Right corner of newly Created Service Appointment")
	public void click_on_the_dropdown_option_on_right_corner_of_newly_created_service_appointment() {
		 appointmentNumber = driver.findElementByXPath("//span[text()='None']/preceding::a[1][@data-refid='recordId']").getText();
		System.out.println(appointmentNumber);
		String appointmnetInitialStatus = driver.findElementByXPath("//span[text()='None']/preceding::a[@data-refid='recordId']//following::td//span[text()='None']").getText();
		System.out.println(appointmnetInitialStatus);
		driver.findElementByXPath("//span[text()='None']/following::a").click();	
	}

	@Then("Dropdown displayed to select cancel service Appointment")
	public void dropdown_displayed_to_select_cancel_service_appointment() {
	  System.out.println("Dropdown displayed to select cancel service Appointment");
	}

	@When("click Option Cancel service  Appointment")
	public void click_option_cancel_service_appointment() {
		driver.findElementByXPath("//a[@title='Cancel Service Appointment']").click();
		
	}

	@Then("Cancel Confirmation Window Displayed")
	public void cancel_confirmation_window_displayed() {
	   System.out.println("Cancel Confirmation Window Displayed");
	}

	@When("click on Confirm Cancellation")
	public void click_on_confirm_cancellation() throws InterruptedException {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Confirm Cancellation']")));
		driver.findElementByXPath("//button[text()='Confirm Cancellation']").click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+appointmentNumber+"']//following::td//span[@class='slds-truncate']")));
		
	}

	@Then("Verify the status of The Appointment")
	public void verify_the_status_of_the_appointment() {
		String appointmentStatus = driver.findElementByXPath("//a[text()='"+appointmentNumber+"']//following::td//span[@class='slds-truncate']").getText();
		System.out.println(appointmentStatus);
	}
}
