package salesForceClassic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classic_EditAccount extends BaseClass{
	@BeforeTest
	public void sheet() {
		sheetName="Classic_EditAccount";
	}
	@Test(dataProvider="fetchData",dependsOnMethods="salesForceClassic.Classic_NewAccount.newAccount")
	public void editAccount(String Address) {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://login.salesforce.com/");
//		driver.findElementById("username").sendKeys("cypress@testleaf.com");
//		driver.findElementById("password").sendKeys("Bootcamp@123");
//		driver.findElementById("Login").click();
		driver.findElementByXPath("//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']//button[@type='button']").click();
		driver.findElementByXPath("//a[contains(text(),'Switch to Salesforce Classic')]").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElementByXPath("//li[@id='MoreTabs_Tab']").click();
		js.executeScript("javascript:window.scrollBy(0,500)");
		driver.findElementByXPath("//a[text()='Accounts']").click();
		String newlyCreatedAccount=driver.findElementByXPath("//th[@scope='row']//a").getText();
		System.out.println(newlyCreatedAccount);
		driver.findElementByXPath("//th[@scope='row']//a").click();
		driver.findElementByXPath("//input[@value=' Edit ']").click();
		js.executeScript("javascript:window.scrollBy(0,300)");
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[4]//textarea").clear();
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[4]//textarea").sendKeys(Address);
		driver.findElementByXPath("(//input[@value=' Save '])[2]").click();
		driver.findElementByXPath("//span[@class='mruText']").click();
		String VerifyChangedShipping = driver.findElementByXPath("//table[@class='detailList']//tbody//tr[9]//td[4]").getText();
		System.out.println(VerifyChangedShipping);
		driver.findElementByXPath("//a[@class='switch-to-lightning']").click();
//		driver.close();
		
	}

}
