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


public class WebdriverMethods {

    public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    Actions action = new Actions(driver);

    @BeforeClass
    public static void OpenBrowser()
    {
    	 System.setProperty("webdriver.chrome.driver","C:/SeleniumJavaDrivers/chromedriver.exe");
         driver= new ChromeDriver();   
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.get("https://www.imdb.com/");
    }
   
    
    
    
    
}
