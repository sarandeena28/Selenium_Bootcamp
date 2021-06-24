package legalEntity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public  ChromeDriver driver;
	public String sheetName;
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		ReadExcel read=new ReadExcel();
		String[][] readData=read.readData(sheetName);
		return readData;
		
	}
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void login(String url,String username,String password) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
	//option.addArguments("start-maximized");
	driver=new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	driver.get(url);
	driver.findElementById("username").sendKeys(username);
	driver.findElementById("password").sendKeys(password);
	driver.findElementById("Login").click();
	driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
	driver.findElementByXPath("//button[text()='View All']").click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("javascript:window.scrollBy(0,500)");
	driver.findElementByXPath("//p[text()='Legal Entities']/ancestor::li").click();
	
	}
}
