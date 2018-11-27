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
	     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     driver.get("https://www.imdb.com/");
    }
    
    @Test
    public void GetTitle()
    {
	     driver.navigate().refresh();
	     if (driver.getTitle().equals("IMDb - Movies, TV and Celebrities - IMDb"))
	    	 System.out.println("Titles are matched");
	     else
	   	    	 System.out.println("Titles are NOT matched");
	    // String PageTitle = driver.getTitle();
	     	//System.out.println(PageTitle);
	     //String ExpectedTitle = "IMDb - Movies, TV and Celebrities - IMDb";
	     //if (PageTitle == ExpectedTitle)
	    	// System.out.println("Titles are matched");
	    // else
	  //  	 System.out.println("Titles are NOT matched");
    }
    
    @AfterClass
    public static void CloseBrowser()
    {
    	driver.quit();
    }
}
