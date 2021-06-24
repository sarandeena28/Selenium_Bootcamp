package customerserviceoptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import customerserviceoptions.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetServiceNameandVerifyTab extends BaseClass {
	@Test
	public void getService() throws InterruptedException {
		
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
