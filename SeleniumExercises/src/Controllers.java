import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Controllers {
	public static WebDriver driver;

	@BeforeClass
	public static void OpenBrowser()
	{
	   	 System.setProperty("webdriver.chrome.driver","C:/SeleniumJavaDrivers/chromedriver.exe");
	   	 driver = new ChromeDriver();
	   	 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     driver.get("http://atidcollege.co.il/Xamples/ex_controllers.html");
	}
	
	@AfterClass
	public static void CloseBrowser()
	{
		driver.quit();
	}
	
	@Test
	public void FillFormShort() 
	{
		driver.findElement(By.name("firstname")).sendKeys("Moral");
		driver.findElement(By.name("lastname")).sendKeys("Marciano");
		Select MyContinent = new Select(driver.findElement(By.id("continents")));
		MyContinent.selectByVisibleText("Europe");
		
		driver.findElement(By.id("sex-1")).click();
		driver.findElement(By.id("exp-1")).click();
		driver.findElement(By.name("datepicker")).click();
		WebElement datewidget = driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> cells = datewidget.findElements(By.tagName("td"));
		for(WebElement cell : cells)
		{
			if(cell.getText().equals("27"))
			{
				cell.click();
				break;
			}
		}
		
		driver.findElement(By.id("profession-0")).click();
		driver.findElement(By.id("photo")).sendKeys("C:/Users/moral/workspace/flower.jpg");
		driver.findElement(By.id("tool-2")).click();
		Select SelenCommands = new Select(driver.findElement(By.id("selenium_commands")));
		SelenCommands.selectByVisibleText("WebElement Commands");
		
		
		driver.findElement(By.id("submit")).click();
		
		String[] dateArr = driver.getCurrentUrl().split("%");
		String mounth = dateArr[0].substring(dateArr[0].length() - 2);
		String day = dateArr[1].substring(2,4);
		String year = dateArr[2].substring(2,6);
		

		
		String URL = driver.getCurrentUrl();
		if(URL.contains("Moral") & URL.contains("Marciano"))
		{
			System.out.println("Test Passed");
			System.out.println(year + "-" + mounth + "-" +day);
		}
		else
		{
			System.out.println("Test Failed");
		}
	}
}
