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
import io.github.bonigarcia.wdm.WebDriverManager;

public class Classic_NewAccount {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElementByXPath("//span[@id='createNewLabel']").click();
		driver.findElementByXPath("//a[text()='Account']").click();
		driver.findElementByXPath("//div[@class='requiredInput']//input").sendKeys("BootCamp Puppeteer_Saranya");
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[2]//textarea").sendKeys("1902 SW 20th Ave");
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr[2]//td[2]//input").sendKeys("Rogers");
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr[3]//td[2]//input").sendKeys("Arkansas");
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr[4]//td[2]//input").sendKeys("72713");
		driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr[5]//td[2]//input").sendKeys("USA");
		driver.findElementByXPath("//a[contains(text(),'Copy Billing Address to Shipping Address')]").click();
		String billingAddr=driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[4]//textarea").getText();
		System.out.println(billingAddr);
		List<WebElement> shippAddress=driver.findElementsByXPath("(//table[@class='detailList'])[2]//tbody//tr//td[4]");
		for (int i = 2; i < shippAddress.size(); i++) {
			String reflectedShippingAddress=driver.findElementByXPath("(//table[@class='detailList'])[2]//tbody//tr["+i+"]//td[4]").getText();
			System.out.println(reflectedShippingAddress);
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
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mruText']")));
		String newlyCreatedAccount=driver.findElementByXPath("//span[@class='mruText']").getText();
		System.out.println(newlyCreatedAccount);
		String VerifynewAccountWindow=driver.findElementByXPath("//h2[text()=' New Account']").getText();
		System.out.println(VerifynewAccountWindow);
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
		driver.close();
	}

}
