package cases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_New_case {

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
		driver.findElementByXPath("//lightning-icon[@class='slds-button slds-button--icon slds-button--icon-small slds-button--icon-container slds-button--icon-x-small slds-global-header__button--icon-actions globalCreateButton slds-icon-utility-add slds-icon_container']/ancestor::a").click();
		driver.findElementByXPath("//a[@title='New Case']").click();
		driver.findElementByXPath("//input[@title='Search Contacts']").click();
		driver.findElementByXPath("//span[@title='New Contact']").click();
		driver.findElementByXPath("(//a[@class='select'])[2]").click();
		driver.findElementByXPath("//a[@title='Mrs.']").click();
		driver.findElementByXPath("//input[@class='firstName compoundBorderBottom form-element__row input']").sendKeys("Saran");
		driver.findElementByXPath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']").sendKeys("ya");
		driver.findElementByXPath("(//button[@title='Save'])[2]").click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='select']"))).click();
		driver.findElementByXPath("//a[@title='Escalated']").click();
		driver.findElementByXPath("//input[@class=' input']").sendKeys("Testing");
		driver.findElementByXPath("// textarea[@class=' textarea']").sendKeys("Dummy");
		driver.findElementByXPath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']").click();
		Thread.sleep(3000);
		String VerifySaveMessage = driver.findElementByXPath("//div[@class='toastContainer slds-notify_container slds-is-relative']//div[@role='alert']").getText();
		System.out.println(VerifySaveMessage);
		SoftAssert checkassert=new SoftAssert();
		checkassert.assertEquals(VerifySaveMessage, "case was Created");
		Thread.sleep(2000);
		if(VerifySaveMessage.contains("case was Created")) {
			System.out.println("Case Succesfully Created");
		}
		else
		{
			System.out.println("Case not Created");
		}
	}

}
