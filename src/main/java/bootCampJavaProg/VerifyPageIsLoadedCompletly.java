package bootCampJavaProg;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyPageIsLoadedCompletly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
                 public Boolean apply(WebDriver driver) {
                	 System.out.println("Success");
                     return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                 }

             };
      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
      wait.until(pageLoadCondition);
 
      
	}

}
