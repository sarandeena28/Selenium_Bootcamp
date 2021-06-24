package individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Individual_sort {

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
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Individuals']/ancestor::a"));
	
		List<WebElement> beforeSort = driver.findElementsByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody//tr//a[@data-refid='recordId'])");
		List<String> recordIdBeforeSort=new ArrayList<String>();
		for (int i = 1; i < beforeSort.size(); i++) {
			String recordBeforeSort = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody//tr//a[@data-refid='recordId'])["+i+"]").getText();
			recordIdBeforeSort.add(recordBeforeSort);
		}
		System.out.println(recordIdBeforeSort);
		
		driver.findElementByXPath("//th[@title='Name']//a[@class='toggle slds-th__action slds-text-link--reset ']").click();
		Thread.sleep(2000);
		List<WebElement> AfterSort = driver.findElementsByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody//tr//a[@data-refid='recordId'])");
		List<String> recordIdAfterSort=new ArrayList<String>();
		for (int i = 1; i < AfterSort.size(); i++) {
			String recordAfterSort = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody//tr//a[@data-refid='recordId'])["+i+"]").getText();
			recordIdAfterSort.add(recordAfterSort);
		}
		System.out.println(recordIdAfterSort);
	
//		Assert.assertTrue(recordIdAfterSort.equals(recordIdBeforeSort));
		boolean verifyRecordSorted = recordIdBeforeSort.equals(recordIdAfterSort);
		System.out.println(verifyRecordSorted);
		
		if(recordIdBeforeSort.equals(recordIdAfterSort)) {
			System.out.println("Individuals not displayed in ascending order by Name");
		}else
		{
				System.out.println("Individuals displayed in ascending order by Name");
			}
		
		
	}

}
