package serviceAppointment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cancel_Service_Appointment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,1000)");
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//p[text()='Service Appointments']/ancestor::a"));
		String appointmentNumber = driver.findElementByXPath("//span[text()='None']/preceding::a[1][@data-refid='recordId']").getText();
		System.out.println(appointmentNumber);
		String appointmnetInitialStatus = driver.findElementByXPath("//span[text()='None']/preceding::a[@data-refid='recordId']//following::td//span[text()='None']").getText();
		System.out.println(appointmnetInitialStatus);
		driver.findElementByXPath("//span[text()='None']/following::a").click();
		driver.findElementByXPath("//a[@title='Cancel Service Appointment']").click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Confirm Cancellation']")));
		driver.findElementByXPath("//button[text()='Confirm Cancellation']").click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+appointmentNumber+"']//following::td//span[@class='slds-truncate']")));
		String appointmentStatus = driver.findElementByXPath("//a[text()='"+appointmentNumber+"']//following::td//span[@class='slds-truncate']").getText();
		System.out.println(appointmentStatus);
	}

}
