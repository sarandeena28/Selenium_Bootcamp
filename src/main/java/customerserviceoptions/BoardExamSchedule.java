package customerserviceoptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BoardExamSchedule extends BaseClass {
	@Test
	public void boardExam() throws InterruptedException {
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
		driver.findElementByXPath("//a[text()='Technical Architect']").click();
		driver.findElementByXPath("//div[@class='cs-review-boards-footer']//a").click();
		windowHandle=driver.getWindowHandles();
		 windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(3));
		List<WebElement> Status = driver.findElementsByXPath("//div[text()='Planning']");
		int count=Status.size();
		System.out.println("No of Planning Status"+count);
		List<WebElement> Location = driver.findElementsByXPath("//div[text()='Planning']/preceding-sibling::div[4]");
		List<WebElement> Date = driver.findElementsByXPath("//div[text()='Planning']/preceding-sibling::div[2]");
		for (int i = 0; i < Location.size(); i++) {
			System.out.println("Location with Planning Status:"+Location.get(i).getText());
			System.out.println("Date with Planning Status:"+Date.get(i).getText());	
		}
		for (int i = 0; i <3; i++) {
			driver.switchTo().window(windowOpen.get(i));
			driver.close();
		}
		
//		Iterator<String> iter=windowHandle.iterator();
//		String[] windowOpens =new String[windowHandle.size()];
//		int i=0;
//		while(iter.hasNext()) {
//			windowOpens[i]=iter.next();
//			i++;
//		}
//		int length = windowOpens.length;
//		System.out.println(length);
//		if(windowOpens.length>0)
//		{
//			for (int j =windowOpens.length-1; j>0; j--) {
//				System.out.println(j);
//				driver.switchTo().window(windowOpens[j-1]);
//				driver.close();
//			}
//		}
		
//		driver.switchTo().window(windowOpens[3]);
		driver.switchTo().window(windowOpen.get(3));
//		driver.switchTo().window(windowOpen.get(2));
//		driver.close();
//		driver.switchTo().window(windowOpen.get(1));
//		driver.close();
//		driver.switchTo().window(windowOpen.get(0));
//		driver.close();
		String PageTitle=driver.getTitle();
		System.out.println(PageTitle);
		if(PageTitle.contains("Architect Review Boards")) {
			System.out.println(" Architect Review Boards Title Verified Successfully");
		}
		else {
			System.out.println("Title verification unsuccesful");
		}
	}

}
