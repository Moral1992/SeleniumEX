import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyClass
{
        public static WebDriver driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions action = new Actions(driver);

        @BeforeClass
	    public static void openBrowser()
        {
        	 System.setProperty("webdriver.chrome.driver","C:/SeleniumJavaDrivers/chromedriver.exe");
             driver= new ChromeDriver();   
		     driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     driver.get("http://atidcollege.co.il/selenium-tag/");
        }	

        @Test
	    public void Test1() throws InterruptedException
        {      
        	driver.findElement(By.id("myName")).sendKeys("Moral Marciano");
        	driver.findElement(By.id("submit")).click();
        	Thread.sleep(2000);
        	WebElement  elem = driver.findElement(By.id("myButton"));
    		action.doubleClick(elem).perform();
    		Thread.sleep(3000);
        }	

        @AfterClass
	    public static void coseBrowser()
        {  
            driver.quit();
        }
}