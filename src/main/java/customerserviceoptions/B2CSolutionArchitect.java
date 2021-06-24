package customerserviceoptions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class B2CSolutionArchitect extends BaseClass {
	@Test
	public void B2CArchitect()throws InterruptedException {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://login.salesforce.com/");
//		driver.findElementById("username").sendKeys("cypress@testleaf.com");
//		driver.findElementById("password").sendKeys("Bootcamp@123");
//		driver.findElementById("Login").click();
		driver.findElementByXPath("//button[@title='Learn More']").click();
		windowHandle=driver.getWindowHandles();
		windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(1));
		WebElement product =driver.findElementByXPath("//span[contains(text(),'Resources')]");
		Actions builder=new Actions(driver);
		builder.moveToElement(product).perform();
		driver.findElementByXPath("//span[contains(text(),'Salesforce Certification')]/ancestor::a").click();
		windowHandle=driver.getWindowHandles();
		 windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(2));
		driver.findElementByXPath("(//a[@class='no-underline']//img)[2]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='B2C Solution Architect']").click();
		List<WebElement> Certifications = driver.findElementsByXPath("(//div[@class='slds-container--center slds-container--x-large slds-p-top--large'])[1]//div[@class='cs-card tile']//div[3]//a");
		for (WebElement B2cCertifications : Certifications) {
			System.out.println(B2cCertifications.getText());
			
		}
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='Marketing Cloud Email Specialist']").click();
		driver.findElementByXPath("//a[text()='Build and Analyze Customer Journeys using Marketing Cloud (MKT101)']").click();
		driver.findElementByXPath("//a[text()='Register Now']").click();
		windowHandle=driver.getWindowHandles();
		 windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(3));
		WebElement location = driver.findElementByXPath("//select[@class='m-combined']");
		Select drop=new Select(location);
		drop.selectByValue("APAC");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class='m-combined'])[2]//option")));
		String preferredLocationText = driver.findElementByXPath("(//select[@class='m-combined'])[2]//option").getText();
		System.out.println(preferredLocationText);
		driver.findElementByXPath("//input[@class='atsInput datepicker']").click();
		//WebElement currentDate = driver.findElementByXPath("//table[@class='calDays']//tbody//tr//td[@class='weekend todayDate']");
		WebElement currentDate = driver.findElementByXPath("//table[@class='calDays']//tbody//tr[2]//td[@class='weekday todayDate']");
		String Today = currentDate.getText();
		driver.findElementByXPath("//table[@class='calDays']//tbody//tr[2]//td[@class='weekend todayDate']").click();
		LocalDate today=LocalDate.now();
		Month month = today.getMonth();
		int monthValue = today.getMonthValue();
		System.out.println(today);
		System.out.println(monthValue);
		int afterEightmonths=monthValue+8;
		System.out.println(afterEightmonths);
		driver.findElementByXPath("(//input[@class='atsInput datepicker'])[2]").click();
		WebElement todate = driver.findElementByXPath("//select[@id='calMonthPicker']");
		Select drop1=new Select(todate);
		drop1.selectByValue(""+afterEightmonths+"");
		driver.findElementByXPath("//table[@class='calDays']//tbody//tr//td[contains(text(),'"+Today+"')]").click();
		driver.findElementByXPath("//a[contains(text(),'Update Search')]").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='m-tbl']//tbody//tr//td[1]")));
		List<WebElement> classNa= driver.findElementsByXPath("//table[@class='m-tbl']//tbody//tr//td[1]");
		int size = classNa.size();
		System.out.println(size);
		for (WebElement className :classNa ) {
			System.out.println(className.getText());
		}
		String cost = driver.findElementByXPath("//table[@class='m-tbl']//tbody//tr[1]//td[@class='numberColumn singleLine']//span").getText();
		System.out.println(cost);
	}

}
