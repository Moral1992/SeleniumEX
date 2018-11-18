import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorAdvEx {
	public static WebDriver driver;

	
	@BeforeClass
    public static void OpenBrowser()
    {
    	 System.setProperty("webdriver.chrome.driver","C:/SeleniumJavaDrivers/chromedriver.exe");
         driver= new ChromeDriver();   
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.get("http://atidcollege.co.il/Xamples/ex_locators.html");
    }
	
	@AfterClass
	public static void CloseBrowser()
	{
		driver.quit();
	}
	
	@Test
	public void findAllElements()
	{
		WebElement FirstLocator = driver.findElement(By.id("locator_id"));
		WebElement SecLocator = driver.findElement(By.name("locator_name"));
		WebElement ThrdLocator = driver.findElement(By.tagName("p"));
		WebElement ForhttLocator = driver.findElement(By.className("locator_class"));
		WebElement FifthLocator = driver.findElement(By.linkText("myLocator(5)"));
		WebElement SixthLocator = driver.findElement(By.partialLinkText("Find my"));
		WebElement SeventhLocator = driver.findElement(By.xpath("//*[contains(@myname,'selenium')]"));
		WebElement EigthLocator = driver.findElement(By.cssSelector("input[class='btn btn-2']"));
		
		System.out.println(FirstLocator);
		System.out.println(SecLocator);
		System.out.println(ThrdLocator);
		System.out.println(ForhttLocator);
		System.out.println(FifthLocator);
		System.out.println(SixthLocator);
		System.out.println(SeventhLocator);
		System.out.println(EigthLocator);
	}
}
