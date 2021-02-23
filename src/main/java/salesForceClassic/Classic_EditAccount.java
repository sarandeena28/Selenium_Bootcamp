package salesForceClassic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classic_EditAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']//button[@type='button']").click();
		driver.findElementByXPath("//a[contains(text(),'Switch to Salesforce Classic')]").click();
		driver.findElementByXPath("//a[text()='Accounts']").click();
		String newlyCreatedAccount=driver.findElementByXPath("//th[@scope='row']//a").getText();
		System.out.println(newlyCreatedAccount);
		driver.findElementByXPath("//th[@scope='row']//a").click();
		driver.findElementByXPath("//input[@value=' Edit ']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,300)");
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[4]//textarea").clear();
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[4]//textarea").sendKeys("1902");
		driver.findElementByXPath("(//input[@value=' Save '])[2]").click();
		driver.findElementByXPath("//span[@class='mruText']").click();
		String VerifyChangedShipping = driver.findElementByXPath("//table[@class='detailList']//tbody//tr[9]//td[4]").getText();
		System.out.println(VerifyChangedShipping);
		driver.findElementByXPath("//a[@class='switch-to-lightning']").click();
		driver.close();
		
	}

}
