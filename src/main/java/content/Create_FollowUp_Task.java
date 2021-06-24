package content;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_FollowUp_Task {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        WebElement eleUserName = driver.findElementById("username");
        eleUserName.sendKeys("cypress@testleaf.com");

        WebElement elePassword = driver.findElementById("password");
        elePassword.sendKeys("Bootcamp@123");
        
        driver.findElementById("Login").click();
		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("//p[text ()='Content']").click();
        driver.findElementByXPath("(//span[text ()='View All'])[2]").click();
        driver.findElementByXPath("//span[text()='Display as Split View']/ancestor::button").click();
        driver.findElementByXPath("//span[text()='Table']/parent::a").click();
        driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
        driver.findElementByXPath("(//a[@title='Create Follow-Up Task'])[2]").click();
        driver.findElementByXPath("//span[@class='pillText']/parent::a").click();
        driver.findElementByXPath("//a[@class='select']").click();
        driver.findElementByXPath("//a[text()='In Progress']").click();
        driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[2]").clear();
        driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[2]").click();
        driver.findElementByXPath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7']/lightning-base-combobox-item").click();
        
	}

}
