package customerserviceoptions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArchitectCertification extends BaseClass {
	@Test
	public void ArchitectCertificate()throws InterruptedException, IOException {
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
		Thread.sleep(2000);
		 windowHandle=driver.getWindowHandles();
		windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(2));
		driver.findElementByXPath("(//a[@class='no-underline']//img)[2]").click();
		Thread.sleep(2000);
		String summary=driver.findElementByXPath("//div[@class='slds-container--center slds-container--medium slds-p-vertical--large']//div").getText();
		System.out.println(summary);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,1300)");
		Thread.sleep(2000);
		File source=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/TechnicalArchitect.png");
		FileUtils.copyFile(source, target);
		Thread.sleep(2000);
		js.executeScript("javascript:window.scrollBy(0,850)");
		File source1=driver.getScreenshotAs(OutputType.FILE);
		File target1=new File("./snaps/SolutionArchitect.png");
		FileUtils.copyFile(source1, target1);
		List<WebElement>certicate=driver.findElementsByXPath("//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']//a[contains(text(),'Architect')]");
		for (WebElement eachCertificate : certicate) {
			System.out.println(eachCertificate.getText());		
		}
		driver.findElementByXPath("//a[text()='Application Architect']").click();
		List<WebElement> ApplicationArchitectCerticate =driver.findElementsByXPath("(//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch'])[1]//div[@class='cs-card tile']//div[3]//a");
		for (WebElement ApplicationArchitectcount : ApplicationArchitectCerticate) {
			System.out.println(ApplicationArchitectcount.getText());
		}
	}

}
