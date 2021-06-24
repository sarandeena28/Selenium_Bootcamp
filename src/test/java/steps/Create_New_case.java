package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create_New_case extends BaseClass{
	@When ("Click on Global Actions SVG icon")
	public void clickSVGIcon() {
		driver.findElementByXPath("//lightning-icon[@class='slds-button slds-button--icon slds-button--icon-small slds-button--icon-container slds-button--icon-x-small slds-global-header__button--icon-actions globalCreateButton slds-icon-utility-add slds-icon_container']/ancestor::a").click();
	}
	@Then("Dropdown display")
	public void verifyCasePage() {
		System.out.println("  Dropdown displayed Succesfully");
	}
	@When("Click on New Case")
	public void clickNewCase() throws InterruptedException {
		driver.findElementByXPath("//a[@title='New Case']").click();
	}
	
	@Then("Choose Contact Name as {string}")
	public void chooseContactName(String contactname) {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Contacts']")));
		driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys(contactname);
		driver.findElementByXPath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']//a[@role='option']").click();
	}
	@And("Select status as Escalated")
	public void selectStatus() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='select']"))).click();
		driver.findElementByXPath("//a[@title='Escalated']").click();
	}
	@And("Enter Subject as {string} and description as {string}")
	public void enterSubjectAndDescription(String subject,String description) {
		driver.findElementByXPath("//input[@class=' input']").sendKeys(subject);
		driver.findElementByXPath("// textarea[@class=' textarea']").sendKeys(description);
	}
	@When("Click save")
	public void clickSave() throws InterruptedException {
	driver.findElementByXPath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']").click();
	Thread.sleep(3000);
	}
	@Then("verify the message")
	public void verifySaveMessage() throws InterruptedException {
	String VerifySaveMessage = driver.findElementByXPath("//div[@class='toastContainer slds-notify_container slds-is-relative']//div[@role='alert']").getText();
	System.out.println(VerifySaveMessage);
	Thread.sleep(2000);
	if(VerifySaveMessage.contains("case was Created")) {
		System.out.println("Case Succesfully Created");
	}
	else
	{
		System.out.println("Case not Created");
	}
	}

}
