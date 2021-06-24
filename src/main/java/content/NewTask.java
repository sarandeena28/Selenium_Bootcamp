package content;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTask {

	public static void main(String[] args) throws InterruptedException {
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
        //driver.findElementByXPath("//p[text ()='Sales']").click();
        driver.findElementByXPath("//p[text ()='Content']").click();
        driver.findElementByXPath("(//span[text ()='View All'])[2]").click();
        WebElement element = driver.findElement(By.xpath("//a[@class='slds-button slds-button_reset']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);       
        WebElement newTask = driver.findElementByXPath("(//a[@role='menuitemcheckbox'])[1]");
        executor.executeScript("arguments[0].click();", newTask);
        


	}

}
