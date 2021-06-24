package customerserviceoptions;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public RemoteWebDriver driver;
	 static String certificationName;
	 static Set<String> windowHandle;
		static List<String> windowOpen;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public  void login(String url,String username,String password) {
//	System.out.println("Choose the browser:");
//	Scanner sc=new Scanner(System.in);
//	String browserType = sc.nextLine();
//	System.out.println(browserType);
		/* ************************************* */
//	if(browser.equalsIgnoreCase("chrome")) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	} else if(browser.equalsIgnoreCase("firefox")) {
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//	} else if(browser.equalsIgnoreCase("ie")) {
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//	}
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
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

