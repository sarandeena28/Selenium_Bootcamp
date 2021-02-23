package salesForceClassic;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classic_NewDashboard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']//button[@type='button']"))).click();
		driver.findElementByXPath("//a[contains(text(),'Switch to Salesforce Classic')]").click();
		driver.findElementByXPath("//li[@id='MoreTabs_Tab']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,500)");
		driver.findElementByXPath("//a[text()='Dashboards']").click();
		driver.findElementByXPath("//a[text()='Go to Dashboard List']").click();
		driver.findElementByXPath("//input[@value='New Dashboard...']").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@class='x-btn-arrow']//button"))).click();
		//driver.findElementByXPath("//em[@class='x-btn-arrow']//button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='x-menu-item']//span[text()='Wide']"))).click();
//		driver.findElementByXPath("//a[@class='x-menu-item']//span[text()='Wide']").click();
		Actions builder=new Actions(driver);
		WebElement source = driver.findElementByXPath("//img[@id='analytics:chart-pie']");
		WebElement target = driver.findElementByXPath("//div[@class='canvasItemNewComponentDropZone x-panel x-panel-noborder']//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']");
		builder.clickAndHold(source).moveToElement(target).release(target).build().perform();
		driver.findElementByXPath("//textarea[@id='dash_description']").sendKeys("NewChartCreated");
		driver.findElementByXPath("//input[@value='Edit Header']").sendKeys("Chart");
		driver.findElementByXPath("//input[@value='Edit Title']").sendKeys("PieChart");
		driver.findElementByXPath("//input[@value='Edit Footer']").sendKeys("Completed");
		WebElement source1 = driver.findElementByXPath("//img[@id='analytics:chart-bar']");
		WebElement target1 = driver.findElementByXPath("//div[@class='canvasItemNewComponentDropZone x-panel x-panel-noborder']//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']");
		builder.clickAndHold(source1).moveToElement(target1).release(target1).build().perform();
		driver.findElementByXPath("(//input[@value='Edit Title'])[2]").sendKeys("BarChart");
		driver.findElementByXPath("(//input[@value='Edit Footer'])[2]").sendKeys("Completed");
		driver.findElementByXPath("//img[@title='Delete']").click();
		driver.findElementByXPath("//button[text()='Yes']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		driver.findElementByXPath("//a[@class='switch-to-lightning']").click();
		driver.close();
	}

}
