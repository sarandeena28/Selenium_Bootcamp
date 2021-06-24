package content;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class New_Chart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementById("username").sendKeys("cypress@testleaf.com");
        driver.findElementById("password").sendKeys("Bootcamp@123");
        driver.findElementById("Login").click();
        driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
        driver.findElementByXPath("//button[text()='View All']").click();
        driver.findElementByXPath("//p[text ()='Content']").click();
        driver.findElementByXPath("(//span[text ()='View All'])[2]").click();
        driver.findElementByXPath("//span[text()='Select List View']/ancestor::a").click();
        driver.findElementByXPath("//span[text()='Open Tasks']/ancestor::a").click();
	}

}
