package customerserviceoptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetServiceNameandVerifyTab {
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
		WebElement product =driver.findElementByXPath("//span[contains(text(),'Products')]");
		Actions builder=new Actions(driver);
		builder.moveToElement(product).perform();
		driver.findElementByXPath("//span[contains(text(),'Service ')]/ancestor::a").click();
		driver.findElementByXPath("//a[contains(text(),'Customer Service')]").click();
		 List<WebElement> service = driver.findElementsByXPath("//a[@class='page-list-item ']");
		 for (WebElement eachService : service) {
			 System.out.println(eachService.getText());
			
		}
		
		 List<WebElement> tab=driver.findElementsByXPath("//ul[@class='wwww-main-nav searchEnabled']//li[@class='nav-item ']");
		 for (WebElement eachValue : tab) {
			// String verify=eachValue.getText();
			 System.out.println(eachValue.getText());
			
		}
		
		
		
	}

}
