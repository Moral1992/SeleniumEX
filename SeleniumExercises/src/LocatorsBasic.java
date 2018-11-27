import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorsBasic {
	public static WebDriver driver;
	
	
	@BeforeClass
    public static void OpenBrowser()
    {
    	 System.setProperty("webdriver.chrome.driver","C:/SeleniumJavaDrivers/chromedriver.exe");
         driver= new ChromeDriver();   
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     driver.get("https://www.seleniumhq.org/");
    }
	
	@AfterClass
	public static void CloseBrowser()
	{
		driver.quit();
	}
	
	@Test
	public void findButton()
	{
		WebElement idElem = driver.findElement(By.id("menu_about"));
		System.out.println(idElem);
	    WebElement LinkElem = driver.findElement(By.linkText("About"));		
	    System.out.println(LinkElem);
	    
	    List<WebElement> TotalLinks = driver.findElements(By.tagName("a"));
	    System.out.println("The total amount of links in this page is: " + TotalLinks.size());
	    List<WebElement> SLinks = driver.findElements(By.partialLinkText("Selenium"));
	    System.out.println("The amount of 'Selenium' links in this page is: " + SLinks.size());
	    List<WebElement> sLinks = driver.findElements(By.partialLinkText("selenium"));
	    System.out.println("The amount of 'selenium' links in this page is: " + sLinks.size());
	}
	

}
	
	

