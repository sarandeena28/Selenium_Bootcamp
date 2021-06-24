package contact;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Update_Contact {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,1000)");
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Contacts']/ancestor::a"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(300));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='countSortedByFilteredBy']")));
		String countofContacts = driver.findElementByXPath("//span[@class='countSortedByFilteredBy']").getText();
		System.out.println(countofContacts);
		int countContact = Integer.parseInt(countofContacts.replaceAll("[^0-9]", ""));
		System.out.println(countContact);
		for (int i = 1; i <=countContact; i++) {
			js.executeScript("arguments[0].scrollIntoView();", driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr["+i+"]"));
			String contactList = driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr["+i+"]").getText();
			System.out.println(contactList);
			js.executeScript("arguments[0].scrollIntoView(false);", driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr["+i+"]"));
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Contact-search-input']")));
		driver.findElementByXPath("//input[@name='Contact-search-input']").sendKeys("yy",Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Show Actions']/ancestor::a")));
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		driver.findElementByXPath("//a[@title='Edit']").click();
		driver.findElementByXPath("//input[@name='Email']").sendKeys("sarandeena@gmail.com");
		String enteredEmail = driver.findElementByXPath("//input[@name='Email']").getAttribute("value");
		System.out.println(enteredEmail);
		driver.findElementByXPath("//label[text()='Lead Source']/following::input[@class='slds-input slds-combobox__input']").click();
		driver.findElementByXPath("//span[text()='Partner Referral']/ancestor::lightning-base-combobox-item").click();
		driver.findElementByXPath("//textarea[@class='slds-textarea']").sendKeys("1902 SW");
		driver.findElementByXPath("//label[text()='Level']/following::input[@class='slds-input slds-combobox__input']").click();
		driver.findElementByXPath("//span[text()='Tertiary']/ancestor::lightning-base-combobox-item").click();
		driver.findElementByXPath("//input[@name='Title']").sendKeys("Automation Testing");
		driver.findElementByXPath("//button[text()='Save']").click();
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
