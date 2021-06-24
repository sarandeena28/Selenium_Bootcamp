package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrailHeadAcademy extends BaseClass{
	@When("Click on Learn More link in Mobile Publisher")
	public void click_on_learn_more_link_in_mobile_publisher() {
		driver.findElementByXPath("//button[@title='Learn More']").click();	
	}

	@Then("My salesforce page will be displayed")
	public void my_salesforce_page_will_be_displayed() {
		System.out.println("My salesforce page will be displayed");
	}

	@When("MouseHover On Resources")
	public void mouse_hover_on_resources() {
		windowHandle=driver.getWindowHandles();
		windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(1));
		WebElement product =driver.findElementByXPath("//span[contains(text(),'Resources')]");
		builder=new Actions(driver);
		builder.moveToElement(product).perform();
	}

	@Then("List of learnings will be displayed")
	public void list_of_learnings_will_be_displayed() {
	 System.out.println("List of learnings will be displayed");
	}

	@When("Select SalesForce Certification Under Learnings")
	public void select_sales_force_certification_under_learnings() {
		driver.findElementByXPath("//span[contains(text(),'Salesforce Certification')]/ancestor::a").click();	
	}

	@Then("Learning Page will be displayed")
	public void learning_page_will_be_displayed() {
	   System.out.println("Learning Page will be displayed");
	}

	@Given("Choose Your Role as Salesforce Consultant")
	public void choose_your_role_as_salesforce_consultant() {
		windowHandle=driver.getWindowHandles();
		 windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(2));
		driver.findElementByXPath("//div[text()='Salesforce Consultant']/parent::a//img").click();	
	}

	@Given("Get the List of Certifications Available")
	public void get_the_list_of_certifications_available() {
		List<WebElement> certification = driver.findElementsByXPath("(//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']//div[@class='cs-card tile'])");
		int size = certification.size();
		System.out.println(size);
		for (int i = 1; i < size; i++) {
			 String cetificationList = driver.findElementByXPath("(//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']//div[@class='cs-card tile'])["+i+"]").getText();
			System.out.println(cetificationList);
		}
		
	}

	@When("Click on Community Cloud Consultant")
	public void click_on_community_cloud_consultant() {
		driver.findElementByXPath("//a[text()='Community Cloud Consultant']").click();
	}

	@Then("Under Related Credentials Check Whether Marketing Cloud Consultant is Available")
	public void under_related_credentials_check_whether_marketing_cloud_consultant_is_available() throws InterruptedException {
		 js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,2500)");
		List<WebElement> relatedCertificate = driver.findElementsByXPath("//div[@class='bg-gray-light slds-p-top--x-large slds-p-bottom--xx-large']//div[@class='cs-card tile']");
		int size=relatedCertificate.size();
		System.out.println(size);
		certificateList=new ArrayList<String>();
		for (int i = 1; i < relatedCertificate.size(); i++) {
			 relatedCertificateList = driver.findElementByXPath("(//div[@class='bg-gray-light slds-p-top--x-large slds-p-bottom--xx-large']//div[@class='cs-card tile']//div[3]//a)["+i+"]").getText();
			 certificateList.add(relatedCertificateList);
		}
		 System.out.println(certificateList);
		Thread.sleep(2000);	
	}

	@When("If Available Click on Marketing Cloud Consultant")
	public void if_available_click_on_marketing_cloud_consultant() {
		if(certificateList.contains("Marketing Cloud Consultant")) {
			wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Marketing Cloud Consultant']")));
			driver.findElementByXPath("//a[text()='Marketing Cloud Consultant']").click();
		}
		else {
			System.out.println("Not available");
		}
	}

	@Then("Marketing Cloud Consultant will be displayed")
	public void marketing_cloud_consultant_will_be_displayed() {
	   System.out.println("Marketing Cloud Consultant will be displayed");
	}

	@When("MouseOver on Learn")
	public void mouse_over_on_learn() {
		WebElement root=driver.findElementByTagName("th-header");
		WebElement shadow1 = (WebElement) js.executeScript("return arguments[0].shadowRoot",root);
		WebElement shadow2 = (WebElement) js.executeScript("return arguments[0].shadowRoot",shadow1.findElement(By.tagName("lwc-tds-header")));
		WebElement shadow3 = (WebElement) js.executeScript("return arguments[0].shadowRoot",shadow2.findElement(By.tagName("lwc-tds-header-desktop")));
		shadow4 = (WebElement) js.executeScript("return arguments[0].shadowRoot",shadow3.findElement(By.tagName("lwc-tds-header-nav")));
//		shadow4.findElement(By.tagName("button")).click();
		WebElement learnToclick = shadow4.findElement(By.tagName("button"));
		builder.moveToElement(learnToclick).perform();
	}

	@Then("learn list displayed below")
	public void learn_list_displayed_below() {
	 System.out.println("Learn List Displayed");
	}

	@When("Click on TrailHead Academy")
	public void click_on_trail_head_academy() {
		WebElement shadow5 = (WebElement) js.executeScript("return arguments[0].shadowRoot",shadow4.findElement(By.tagName("lwc-tds-header-nav-item")));
		shadow5.findElement(By.cssSelector("div>a[data-label='Trailhead Academy']")).click();
	}

	@Then("Get the Number of Classes Available Before Filtering")
	public void get_the_number_of_classes_available_before_filtering() {
		List<WebElement> classes = driver.findElementsByXPath("//div[@class='thac-card_text']//div//a");
		classList=new ArrayList<String>();
		int classCount = classes.size();
		System.out.println(classCount);
		for (int i = 1; i < classCount; i++) {
			noOfClass = driver.findElementByXPath("(//div[@class='thac-card_text']//div//a)["+i+"]").getText();
			System.out.println(noOfClass);
			classList.add(noOfClass);
		}
		System.out.println(classList);
	}

	@Given("Under Role Select all Options Available")
	public void under_role_select_all_options_available() {
		driver.findElementByXPath("//button[@class='thac-custom-multiselect--value']").click();
		List<WebElement> role = driver.findElementsByXPath("//div[@id='custom-filter_Role']//input[@type='checkbox']/parent::button");
		for ( WebElement Role : role ) {
			Role.click();
		}

	}

	@Given("Under Level Select all Options Available")
	public void under_level_select_all_options_available() {
		driver.findElementByXPath("//button[text()='Level']").click();
		List<WebElement> level = driver.findElementsByXPath("//div[@id='custom-filter_Level']//input[@type='checkbox']/parent::button");
		for ( WebElement Level : level ) {
			Level.click();
	}
	}

	@Given("Under Product Select all Options Available")
	public void under_product_select_all_options_available() {
		driver.findElementByXPath("//button[text()='Product']").click();
		List<WebElement> products = driver.findElementsByXPath("//div[@id='custom-filter_Product']//input[@type='checkbox']/parent::button");
		for (WebElement Product : products) {
			Product.click();
		}
	}

	@Given("Under Tags Select all Options Available")
	public void under_tags_select_all_options_available() {
		driver.findElementByXPath("//button[text()='Tags']").click();
		List<WebElement> tags = driver.findElementsByXPath("//div[@id='custom-filter_Tags']//input[@type='checkbox']/parent::button");
		for (WebElement Tag : tags) {
			Tag.click();
		}
	}

	@Given("Get The Number of Classes Available after Filtering")
	public void get_the_number_of_classes_available_after_filtering() {
		List<WebElement> afterFilterClasses = driver.findElementsByXPath("//div[@class='thac-card_text']//div//a");
		int Count = afterFilterClasses.size();
		afterFilterclassList=new ArrayList<String>();
		for (int i = 1; i < Count; i++) {
			afterFilterclass= driver.findElementByXPath("(//div[@class='thac-card_text']//div//a)["+i+"]").getText();
			System.out.println(afterFilterclass);
			afterFilterclassList.add(afterFilterclass);
		}	
		System.out.println(afterFilterclassList);
	}

	@Given("Compare and Check whether the Classes are same Before and After Filtering")
	public void compare_and_check_whether_the_classes_are_same_before_and_after_filtering() {
		if(afterFilterclassList.containsAll(classList)) {
			System.out.println(" Classes are same Before and After Filtering");
		}else {
			System.out.println(" Classes are not same Before and After Filtering");
		}
	}

	@Given("Get the names of all Filter Options Displayed")
	public void get_the_names_of_all_filter_options_displayed() {
		List<WebElement> filterTags = driver.findElementsByXPath("//div[@class='filter-tags--item slds-float--left']");
		addedFilter=new ArrayList<String>();
		for (int i = 1; i < filterTags.size(); i++) {
			String listOfFilterTags = driver.findElementByXPath("(//div[@class='filter-tags--item slds-float--left'])["+i+"]").getText();
			addedFilter.add(listOfFilterTags);
			System.out.println(addedFilter);
		}
	}

	@When("Click on Clear Filters")
	public void click_on_clear_filters() {
		driver.findElementByXPath("//button[text()='Clear filters']").click();
	}

	@Then("Verify Whether all Filters are Cleared")
	public void verify_whether_all_filters_are_cleared() {
		String afterclearingFilter = driver.findElementByXPath("//div[@class='filter-tags slds-clearfix']").getText();
		System.out.println(afterclearingFilter);
		if(addedFilter.equals(afterclearingFilter)) {
			System.out.println("Filters not Cleared");
		}
		else {
			System.out.println("Filters  Cleared Succesfully");
		}  
	}

}
