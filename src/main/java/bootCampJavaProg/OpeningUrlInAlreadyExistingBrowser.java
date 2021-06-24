package bootCampJavaProg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpeningUrlInAlreadyExistingBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jegan\\eclipse-workspace\\samplepro1\\drivers\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("disable-popup-blocking");
	    options.setExperimentalOption("debuggerAddress", "localhost:9028");
	    ChromeDriver driver = new ChromeDriver(options);
	    System.out.println(driver.getTitle());
//		driver.get("https://login.salesforce.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElementById("username").sendKeys("cypress@testleaf.com");
//        driver.findElementById("password").sendKeys("Bootcamp@123");
//        driver.findElementById("Login").click();
        driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
        driver.findElementByXPath("//button[text()='View All']").click();
    
	}

}
