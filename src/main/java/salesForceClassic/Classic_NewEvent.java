package salesForceClassic;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classic_NewEvent extends BaseClass {
	
	@Test(dataProvider="fetchData")
	public void testcase(String subject) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']//button[@type='button']"))).click();
//		driver.findElementByXPath("//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']//button[@type='button']").click();
		driver.findElementByXPath("//a[contains(text(),'Switch to Salesforce Classic')]").click();
		driver.findElementByXPath("//div[@id='createNewButton']").click();
		driver.findElementByXPath("//a[text()='Event']").click();
		driver.findElementByXPath("(//div[@class='requiredInput'])[2]//input[@type='text']").sendKeys(subject);
//		driver.findElementByXPath("//img[@class='comboboxIcon']/parent::a").click();
//		windowHandle=driver.getWindowHandles();
//		windowOpen=new ArrayList<String>(windowHandle);
//		driver.switchTo().window(windowOpen.get(1));
//		driver.findElementByXPath("//a[text()='Call']").click();
//		driver.switchTo().window(windowOpen.get(0));
		LocalDate today=LocalDate.now();
		LocalDate plusDays = today.plusDays(1);
		System.out.println(plusDays);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		String oneplusdate = dtf.format(plusDays);
		System.out.println(oneplusdate);
		LocalDate plus2Days = today.plusDays(2);
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		String twoplusdate = dtf1.format(plus2Days);
		System.out.println(twoplusdate);
		driver.findElementByXPath("//input[@id='StartDateTime']").clear();
		driver.findElementByXPath("//input[@id='StartDateTime']").sendKeys(oneplusdate);
		driver.findElementByXPath("//input[@id='EndDateTime']").clear();
		driver.findElementByXPath("//input[@id='EndDateTime']").sendKeys(twoplusdate);
		driver.findElementByXPath("//a[@id='whobtn']").click();
		windowHandle=driver.getWindowHandles();
		windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(1));
		WebElement frame = driver.findElementByXPath("//frame[@title='Search']");
		driver.switchTo().frame(frame);
		driver.findElementByXPath("//input[@id='lksrch']").sendKeys("de");
		driver.findElementByXPath("//input[@name='go']").click();
		driver.switchTo().defaultContent();
		WebElement resultFrame = driver.findElementByXPath("//frame[@title='Results']");
		driver.switchTo().frame(resultFrame);
		driver.findElementByXPath("//a[text()='def boo']").click();
		driver.switchTo().window(windowOpen.get(0));
		driver.findElementByXPath("//input[@name='attachFile']").click();
		windowHandle=driver.getWindowHandles();
		windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(1));
		WebElement uploadFile= driver.findElementByXPath("//input[@id='file']");
		//Choose a File
		uploadFile.sendKeys("C:\\Ganesh\\checkingUpload.txt");
		//Attach File
        driver.findElementByXPath("//input[@id='Attach']").click();
        Thread.sleep(9000);
        //click the "Done" button
        driver.findElementByXPath("//input[@value=' Done ']").click();
        driver.switchTo().window(windowOpen.get(0));
        String verifyFile = driver.findElementByXPath("//span[@class='advisory']").getText();
        System.out.println(verifyFile);
        driver.findElementByXPath("(//input[@name='save'])[2]").click();
        String newEvent = driver.findElementByXPath("//span[@class='mruText']").getText();
        System.out.println(newEvent);
		driver.findElementByXPath("//a[@class='switch-to-lightning']").click();
		
	}
	
	

}
