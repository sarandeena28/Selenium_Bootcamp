package userProvisioning;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_New_Provisioning {
	static Set<String> windowHandle;
	static List<String> windowOpen;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		//option.addArguments("start-maximized");
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
		js.executeScript("javascript:window.scrollBy(0,500)");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='User Provisioning Requests']/ancestor::li"))).click();
		driver.findElementByXPath("//a[text()='Open in Salesforce Classic.']").click();
		windowHandle=driver.getWindowHandles();
		 windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(1));
		driver.findElementByXPath("//a[text()='Create New View']").click();
		driver.findElementByXPath("//input[@id='fname']").sendKeys("Snorky_SaranJ");
		String provisionName = driver.findElementByXPath("//input[@id='fname']").getAttribute("value");
		System.out.println(provisionName);
		driver.findElementByXPath("//input[@id='devname']").sendKeys("SaranJ_30");
		driver.findElementByXPath("(//input[@class=' radio'])[2]").click();
		WebElement selectName = driver.findElementByXPath("//select[@id='fcol1']");
		Select name=new Select(selectName);
		name.selectByValue("Name");
		List<WebElement> getValues = driver.findElementsByXPath("//select[@id='fcol2']//option");
		int dropdownCount = getValues.size();
		System.out.println(dropdownCount);
		for (int i = 1; i <=dropdownCount ; i++) {
		String allValues = driver.findElementByXPath("//select[@id='fcol2']//option["+i+"]").getText();
		System.out.println(allValues);
			
		}
		name.selectByValue("CreatedDate");
		List<WebElement> getAvailableFields = driver.findElementsByXPath("//div[@id='colselector']//table//tr//td[1]//select//option");
		int availableFieldSize = getAvailableFields.size();
		for (int i = 1; i <=availableFieldSize ; i++) {
			String availableFields = driver.findElementByXPath("//div[@id='colselector']//table//tr//td[1]//select//option["+i+"]").getText();
			System.out.println(availableFields);
		}
		List<WebElement> getSelectedFields = driver.findElementsByXPath("//div[@id='colselector']//table//tr//td[3]//select//option");
		int selectedFieldSize = getSelectedFields.size();
		for (int i = 1; i <=selectedFieldSize ; i++) {
			String selectedFields = driver.findElementByXPath("//div[@id='colselector']//table//tr//td[3]//select//option["+i+"]").getText();
			System.out.println(selectedFields);
		}
		WebElement selectOption=driver.findElementByXPath("//div[@id='colselector']//table//tr//td[1]//select");
		Select selectoption=new Select(selectOption);
		selectoption.selectByVisibleText("System Modstamp");
		driver.findElementByXPath("//img[@class='rightArrowIcon']/parent::a").click();
		driver.findElementByXPath("//img[@class='rightArrowIcon']/parent::a").click();
		List<WebElement> getnewlySelectedField = driver.findElementsByXPath("//div[@id='colselector']//table//tr//td[3]//select//option");
		int getnewlySelectedFieldSize = getnewlySelectedField.size();
		System.out.println(getnewlySelectedFieldSize);
		String newlyAdedOption = driver.findElementByXPath("//div[@id='colselector']//table//tr//td[3]//select//option["+getnewlySelectedFieldSize+"]").getText();
		System.out.println(newlyAdedOption);
		driver.findElementByXPath("//input[@id='fsharefshareall']").click();
		driver.findElementByXPath("(//input[@name='save'])[2]").click();
		String verifyNewCreatedProvision = driver.findElementByXPath("//h1[@class='noSecondHeader pageType']").getText();
		System.out.println(verifyNewCreatedProvision);
		if(verifyNewCreatedProvision.contains(provisionName)) {
			System.out.println("New user Created  Succesfully");
		}
		else {
			System.out.println("New User not Created");
		}
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowOpen.get(0));
		driver.close();

	}

}
