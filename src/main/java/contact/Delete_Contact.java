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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Contact {

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
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(400));
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
//		List<WebElement> contacts = driver.findElementsByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr");
//		int size = contacts.size();
//		System.out.println(size);
//		for (int i = 1; i < size; i++) {
//			String contactList = driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr["+i+"]").getText();
//			System.out.println(contactList);
//		}
		driver.findElementByXPath("//input[@name='Contact-search-input']").sendKeys("yy",Keys.ENTER);
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@data-refid='recordId']")));
		String contactName = driver.findElementByXPath("//a[@data-refid='recordId']").getText();
		System.out.println(contactName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Show Actions']/ancestor::a")));
		driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		driver.findElementByXPath("//a[@title='Delete']").click();
		driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
		String deleteMsg = driver.findElementByXPath("//span[@data-aura-class='forceActionsText']").getText();
		System.out.println(deleteMsg);
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
