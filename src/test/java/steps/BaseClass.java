package steps;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public  static RemoteWebDriver driver;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	public static String newDashboardName;
	public static String countofContacts;
	public static int countContact;
	public static String enteredEmail;
	public static String contactName ;
	public static Set<String> windowHandle;
	public static List<String> windowOpen;
	public static String  relatedCertificateList;
	public static 	List<String> certificateList;
	public static String appointmentNumber;
	public static Actions builder;
	public static WebElement shadow4;
	public static String noOfClass;
	public static String afterFilterclass;
	public static List<String> classList;
	public static List<String> afterFilterclassList;
	public static List<String> addedFilter;
	
}
