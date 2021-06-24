package sales;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_NewlyCreated_Opportunity_UnderCampaign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Selbootcamp@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("//p[text()='Sales']/ancestor::div[@class='slds-app-launcher__tile-body slds-truncate']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='Opportunities']/ancestor::a"));
		String oppurtunityName = driver.findElementByXPath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//tbody//tr//th//a").getText();
		System.out.println(oppurtunityName);
		driver.findElementByXPath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//tbody//tr//th//a").click();
		WebElement element = driver.findElementByXPath("//span[contains(text(),'Show more actions')]/ancestor::button");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.stalenessOf(element));
		driver.findElementByXPath("//span[contains(text(),'Show more actions')]/ancestor::button").click();
		driver.findElementByXPath("//span[contains(text(),'Delete')]/parent::a").click();
		driver.findElementByXPath("//span[contains(text(),'Delete')]/parent::button").click();
		String deleteMessage = driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
		System.out.println(deleteMessage);
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(oppurtunityName,Keys.ENTER);
		String msg = driver.findElementByXPath("//div[@class='emptyContentInner slds-text-align_center']//p").getText();
		System.out.println(msg);
		
	}

}
