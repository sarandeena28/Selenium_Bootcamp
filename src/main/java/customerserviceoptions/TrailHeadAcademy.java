package customerserviceoptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrailHeadAcademy {
	public static String relatedCertificateList ;
	public static RemoteWebDriver driver;
	public static String noOfClass;
	public static String afterFilterclass;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();
		driver.findElementByXPath("//button[@title='Learn More']").click();
		Set<String> windowHandle=driver.getWindowHandles();
		List<String> windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(1));
		WebElement product =driver.findElementByXPath("//span[contains(text(),'Resources')]");
		Actions builder=new Actions(driver);
		builder.moveToElement(product).perform();
		driver.findElementByXPath("//span[contains(text(),'Salesforce Certification')]/ancestor::a").click();
		windowHandle=driver.getWindowHandles();
		 windowOpen=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowOpen.get(2));
		driver.findElementByXPath("//div[text()='Salesforce Consultant']/parent::a//img").click();
		List<WebElement> certification = driver.findElementsByXPath("(//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']//div[@class='cs-card tile'])");
		int size = certification.size();
		System.out.println(size);
		for (int i = 1; i < size; i++) {
			 String cetificationList = driver.findElementByXPath("(//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']//div[@class='cs-card tile'])["+i+"]").getText();
			System.out.println(cetificationList);
		}
		driver.findElementByXPath("//a[text()='Community Cloud Consultant']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,2500)");
		List<WebElement> relatedCertificate = driver.findElementsByXPath("//div[@class='bg-gray-light slds-p-top--x-large slds-p-bottom--xx-large']//div[@class='cs-card tile']");
		System.out.println(relatedCertificate.size());
		List<String> certificateList=new ArrayList<String>();
		for (int i = 1; i < relatedCertificate.size(); i++) {
			 relatedCertificateList = driver.findElementByXPath("(//div[@class='bg-gray-light slds-p-top--x-large slds-p-bottom--xx-large']//div[@class='cs-card tile']//div[3]//a)["+i+"]").getText();
			 certificateList.add(relatedCertificateList);
		}
		 System.out.println(certificateList);
		 
		Thread.sleep(2000);
	
		if(certificateList.contains("Marketing Cloud Consultant")) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Marketing Cloud Consultant']")));
			driver.findElementByXPath("//a[text()='Marketing Cloud Consultant']").click();
		}
		else {
			System.out.println("Not available");
		}
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
//		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[text()='Learn']")));
//		WebElement mouseOverLearn =driver.findElementByCssSelector("button.nav-list-item__button");
//		Actions action=new Actions(driver);
//		action.moveToElement(mouseOverLearn).perform();
//		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-label='Trailhead Academy']")));
//		WebElement clickTrailAcademy= driver.findElementByCssSelector("div.contains('Trailhead Academy')");
//		clickTrailAcademy.click();
		WebElement root=driver.findElementByTagName("th-header");
		WebElement shadow1 = (WebElement) js.executeScript("return arguments[0].shadowRoot",root);
		WebElement shadow2 = (WebElement) js.executeScript("return arguments[0].shadowRoot",shadow1.findElement(By.tagName("lwc-tds-header")));
		WebElement shadow3 = (WebElement) js.executeScript("return arguments[0].shadowRoot",shadow2.findElement(By.tagName("lwc-tds-header-desktop")));
		WebElement shadow4 = (WebElement) js.executeScript("return arguments[0].shadowRoot",shadow3.findElement(By.tagName("lwc-tds-header-nav")));
//		shadow4.findElement(By.tagName("button")).click();
		WebElement learnToclick = shadow4.findElement(By.tagName("button"));
		builder.moveToElement(learnToclick).perform();
		WebElement shadow5 = (WebElement) js.executeScript("return arguments[0].shadowRoot",shadow4.findElement(By.tagName("lwc-tds-header-nav-item")));
//		Thread.sleep(2000);
		shadow5.findElement(By.cssSelector("div>a[data-label='Trailhead Academy']")).click();
		List<WebElement> classes = driver.findElementsByXPath("//div[@class='thac-card_text']//div//a");
		List<String> classList=new ArrayList<String>();
		int classCount = classes.size();
		System.out.println(classCount);
		for (int i = 1; i < classCount; i++) {
			noOfClass = driver.findElementByXPath("(//div[@class='thac-card_text']//div//a)["+i+"]").getText();
			System.out.println(noOfClass);
			classList.add(noOfClass);
		}
		System.out.println(classList);
		driver.findElementByXPath("//button[@class='thac-custom-multiselect--value']").click();
		List<WebElement> role = driver.findElementsByXPath("//div[@id='custom-filter_Role']//input[@type='checkbox']/parent::button");
		for ( WebElement Role : role ) {
			Role.click();
		}

		driver.findElementByXPath("//button[text()='Level']").click();
		List<WebElement> level = driver.findElementsByXPath("//div[@id='custom-filter_Level']//input[@type='checkbox']/parent::button");
		for ( WebElement Level : level ) {
			Level.click();
	}
		
		driver.findElementByXPath("//button[text()='Product']").click();
		List<WebElement> products = driver.findElementsByXPath("//div[@id='custom-filter_Product']//input[@type='checkbox']/parent::button");
		for (WebElement Product : products) {
			Product.click();
		}

		driver.findElementByXPath("//button[text()='Tags']").click();
		List<WebElement> tags = driver.findElementsByXPath("//div[@id='custom-filter_Tags']//input[@type='checkbox']/parent::button");
		for (WebElement Tag : tags) {
			Tag.click();
		}

		List<WebElement> afterFilterClasses = driver.findElementsByXPath("//div[@class='thac-card_text']//div//a");
		int Count = afterFilterClasses.size();
		List<String> afterFilterclassList=new ArrayList<String>();
		for (int i = 1; i < Count; i++) {
			afterFilterclass= driver.findElementByXPath("(//div[@class='thac-card_text']//div//a)["+i+"]").getText();
			System.out.println(afterFilterclass);
			afterFilterclassList.add(afterFilterclass);
		}	
		System.out.println(afterFilterclassList);
		if(afterFilterclassList.containsAll(classList)) {
			System.out.println(" Classes are same Before and After Filtering");
		}else {
			System.out.println(" Classes are not same Before and After Filtering");
		}
		List<WebElement> filterTags = driver.findElementsByXPath("//div[@class='filter-tags--item slds-float--left']");
		List<String> addedFilter=new ArrayList<String>();
		for (int i = 1; i < filterTags.size(); i++) {
			String listOfFilterTags = driver.findElementByXPath("(//div[@class='filter-tags--item slds-float--left'])["+i+"]").getText();
			addedFilter.add(listOfFilterTags);
			System.out.println(addedFilter);
		}
		driver.findElementByXPath("//button[text()='Clear filters']").click();
		String afterclearingFilter = driver.findElementByXPath("//div[@class='filter-tags slds-clearfix']").getText();
		System.out.println(afterclearingFilter);
		if(addedFilter.equals(afterclearingFilter)) {
			System.out.println("Filters not Cleared");
		}
		else {
			System.out.println("Filters  Cleared Succesfully");
		}
	}

}
