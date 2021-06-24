package legalEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LegalEntities_sortbyLastModifiedDate extends BaseClass {
	@Test
	public void legalEntities_sortbyLastModifiedDate()throws InterruptedException, ParseException {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions option=new ChromeOptions();
//		option.addArguments("--disable-notifications");
//		//option.addArguments("start-maximized");
//		ChromeDriver driver=new ChromeDriver(option);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://login.salesforce.com/");
//		driver.findElementById("username").sendKeys("cypress@testleaf.com");
//		driver.findElementById("password").sendKeys("Bootcamp@123");
//		driver.findElementById("Login").click();
//		driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
//		driver.findElementByXPath("//button[text()='View All']").click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("javascript:window.scrollBy(0,500)");
//		driver.findElementByXPath("//p[text()='Legal Entities']/ancestor::li").click();
//		String descendingOrderDates = driver.findElementByXPath("//span[@class='slds-truncate uiOutputDateTime']").getText();
//		System.out.println(descendingOrderDates);

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Sort')])[2]/ancestor::a")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Sort')])[2]/ancestor::a")));
		driver.findElementByXPath("(//span[contains(text(),'Sort')])[3]/ancestor::a").click();
//		WebElement lastModifiedDates = driver.findElementByXPath("(//span[contains(text(),'Sort')])[2]/ancestor::a");
//		Actions builder=new Actions(driver);
//		builder.moveToElement(lastModifiedDates).doubleClick(lastModifiedDates).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='slds-truncate uiOutputDateTime']")));
		List<WebElement> lastModifiedDate = driver.findElementsByXPath("//span[@class='slds-truncate uiOutputDateTime']");
		List getDates=new ArrayList();
		for (int i = 0; i <lastModifiedDate.size(); i++) {
			String text = lastModifiedDate.get(i).getText();
			getDates.add(text);			
			}

		for (int j = 0; j <lastModifiedDate.size()-1; j++) {
			String firstEntry = getDates.get(j).toString();
			System.out.println(firstEntry);
			String nextEntry = getDates.get(j+1).toString();
			System.out.println(nextEntry);
			 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy, hh:mm a"); 
			 Date firstEntryDate = formatter.parse(firstEntry);
			System.out.println(firstEntryDate);
			Date NextEntryDate =formatter.parse(nextEntry);
		    System.out.println(NextEntryDate);		
		    if(NextEntryDate.after(firstEntryDate)) {
				System.out.println("Dates are in ascending order by Last Modified Date verified Successfully ");
			}
			else {
				System.out.println("Dates are in descending order by Last Modified Date ");
			}
		
		}
		
	}
}
		
		
		
		
		
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='slds-truncate uiOutputDateTime']")));
//		Thread.sleep(2000);
//		String AscendingOrderDate = driver.findElementByXPath("//span[@class='slds-truncate uiOutputDateTime']").getText();
//		System.out.println(AscendingOrderDate);
//		String[] splitdescDate = descendingOrderDates.split(",");
//		System.out.println(splitdescDate[0]);
//		String descDate = splitdescDate[0].toString();
//		System.out.println(descDate);
//		String[] splitascDate = AscendingOrderDate.split(",");
//		System.out.println(splitascDate[0]);
//		String ascDate = splitascDate[0].toString();
//		System.out.println(ascDate);
//		 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
//		    Date descendingdate = (Date)formatter.parse(descDate);
//		    System.out.println(descendingdate);
//		    Date ascendingdate = (Date)formatter.parse(ascDate);
//		    System.out.println(ascendingdate);
//		if(descendingdate.after(ascendingdate)) {
//			System.out.println("Dates are in ascending order by Last Modified Date verified Successfully ");
//		}
//		else {
//			System.out.println("Dates are in descending order by Last Modified Date ");
//		}
//		if(descendingOrderDates.contains(AscendingOrderDate){
//			System.out.println("Dates are in descending order by Last Modified Date ");
//		}
//		else {
//			System.out.println("Dates are in ascending order by Last Modified Date verified Successfully ");
//		}
//		List<WebElement> lastModifiedDate = driver.findElementsByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr//td[3]//span[@class='slds-truncate uiOutputDateTime']");
//		for (int i = 1; i < lastModifiedDate.size(); i++) {
//			String listOfDates = driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']//tbody//tr["+i+"]//td[3]//span[@class='slds-truncate uiOutputDateTime']").getText();
//			System.out.println(listOfDates);
//		}
	


