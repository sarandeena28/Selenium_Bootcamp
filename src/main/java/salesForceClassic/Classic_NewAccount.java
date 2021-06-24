package salesForceClassic;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classic_NewAccount extends BaseClass{
	public static String reflectedShippingAddress;
	public static String billingAddress;
	@BeforeTest
	public void sheet() {
		sheetName="Classic_NewAccount";
	}
	@Test(dataProvider="fetchData")
	public void newAccount(String Name,String Address,String City,String State,String Pincode,String Country) throws InterruptedException {
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
		driver.findElementByXPath("//span[@id='createNewLabel']").click();
		driver.findElementByXPath("//a[text()='Account']").click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='requiredInput']//input")));
		driver.findElementByXPath("//div[@class='requiredInput']//input").sendKeys(Name);
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[2]//textarea").sendKeys(Address);
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr[2]//td[2]//input").sendKeys(City);
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr[3]//td[2]//input").sendKeys(State);
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr[4]//td[2]//input").sendKeys(Pincode);
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr[5]//td[2]//input").sendKeys(Country);
		driver.findElementByXPath("//a[contains(text(),'Copy Billing Address to Shipping Address')]").click();
		String shippingStreetBilling=driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[2]//textarea").getAttribute("value");
		System.out.println(shippingStreetBilling);
		List<WebElement> billingAddr=driver.findElementsByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[2]//input");
		int count = billingAddr.size();
		System.out.println(count);
		for (int j = 2; j < billingAddr.size(); j++) {
			billingAddress=driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr["+j+"]//td[2]//input").getAttribute("value");
			System.out.println(billingAddress);
		}
		String shippingStreet=driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[4]//textarea").getAttribute("value");
		System.out.println(shippingStreet);
		List<WebElement> shippAddress=driver.findElementsByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[4]//input");
		for (int i = 2; i < shippAddress.size(); i++) {
			reflectedShippingAddress=driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr["+i+"]//td[4]//input").getAttribute("value");
			System.out.println(reflectedShippingAddress);
		}
		if(billingAddress.contains(reflectedShippingAddress))
		{
			System.out.println("Billing Address reflected in Shipping Address succesfully");
		}
		else {
			System.out.println("Billing Address not reflected in Shipping Address succesfully");
		}
		
		LocalDate today=LocalDate.now();
		LocalDate date=today.plusDays(20);
		int monthValue=date.getMonthValue();
		System.out.println(date);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		String month_name = dtf2.format(date);
		System.out.println(month_name);
		driver.findElementByXPath("//span[@class='dateInput dateOnlyInput']//input").sendKeys(month_name);
		driver.findElementByXPath("(//input[@name='save_new'])[2]").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mruText']")));
		String newlyCreatedAccount=driver.findElementByXPath("//span[@class='mruText']").getText();
		System.out.println(newlyCreatedAccount);
		String VerifynewAccountWindow=driver.findElementByXPath("//h2[text()=' New Account']").getText();
		System.out.println(VerifynewAccountWindow);
		driver.findElementByXPath("//li[@id='MoreTabs_Tab']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,500)");
		driver.findElementByXPath("//a[text()='Accounts']").click();
		String veriftNewAcoount = driver.findElementByXPath("//th[@scope='row']//a").getText();
		System.out.println(veriftNewAcoount);
		if(veriftNewAcoount.contains(newlyCreatedAccount)) {
			System.out.println("Newly Created Item Displayed Succesfully");
		}
		else {
			System.out.println("Newly Created Item not Displayed");
		}
		driver.findElementByXPath("//a[@class='switch-to-lightning']").click();
//		driver.close();
	}

}
