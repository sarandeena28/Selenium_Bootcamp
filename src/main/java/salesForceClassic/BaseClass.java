package salesForceClassic;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {	
	public ChromeDriver driver;
	public Set<String> windowHandle;
	public List<String> windowOpen;
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException{
		ReadExcel read=new ReadExcel();
		String[][] readData=read.readData();
		return readData;
	}
	@BeforeMethod
	public void login() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
}
