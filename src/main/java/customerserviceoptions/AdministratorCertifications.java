package customerserviceoptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdministratorCertifications {
	 static String certificationName;
	 static Set<String> windowHandle;
		static List<String> windowOpen;
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
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,300)");
		  Thread.sleep(2000);
		 List<WebElement> certification =driver.findElementsByXPath("//div[@class='slds-size--1-of-1 slds-large-size--1-of-3 slds-p-horizontal--medium slds-p-vertical--medium']//div[3]//a");

		 for (WebElement eachCertification : certification) {
			  certificationName=eachCertification.getText();
			 System.out.println(certificationName);
			 if(certificationName.equals("Administrator"))
			 {
				 System.out.println("Administrator Certification is Available and Verification Successfull");
				
			 }
			 else
			 {
				 System.out.println("Administrator Certification not Available and Verification unsuccessfull");
			 }
		}
		 
		 
		 driver.findElementByXPath("//a[text()='Administrator']").click();
		 List<WebElement> classWorkshop=driver.findElementsByXPath("//ul//li//a[contains(text(),'Admin')]");
		 for (WebElement classText : classWorkshop) {
			 
			 System.out.println( classText.getText());		 
		}
		 String PageTitle=driver.getTitle();
		System.out.println(PageTitle);
		if(PageTitle.contains("Certification - Administrator")) {
			System.out.println("Certification - Administrator Title Verified Successfully");
		}
		else {
			System.out.println("Title verification unsuccesful");
		}
		 
	}

}
