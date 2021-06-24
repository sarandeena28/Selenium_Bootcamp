package salesForceClassic;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {	
	public ChromeDriver driver;
	public Set<String> windowHandle;
	public List<String> windowOpen;
	public String sheetName;
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException{
		ReadExcel read=new ReadExcel();
		String[][] readData=read.readData(sheetName);
		return readData;
	}
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void login(String url,String username ,String password) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementById("Login").click();
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
}
