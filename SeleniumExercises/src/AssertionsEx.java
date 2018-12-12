import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class AssertionsEx {

	public static WebDriver driver;
	
	@BeforeClass
	public static void OpenBrowser()
	{
	   	 System.setProperty("webdriver.chrome.driver","C:/SeleniumJavaDrivers/chromedriver.exe");
	   	 driver = new ChromeDriver();
	   	 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     driver.get("http://blog.yoniflenner.net/Samples/BMICalc/");
	}
	
	@AfterClass
	public static void CloseBrowser()
	{
		driver.quit();
	}
	
	@Test
	public void AssertBMICalc() throws InterruptedException   
	{
		driver.findElement(By.id("weight")).sendKeys("49");
		driver.findElement(By.id("hight")).sendKeys("165");
		driver.findElement(By.id("calculate_data")).click();
		Thread.sleep(3000);
		String ExpectedRes = "17.998163452708905";
		String ActualRes = driver.findElement(By.id("bmi_result")).getAttribute("value");
		assertEquals(ExpectedRes, ActualRes);
	}
	
	@Test
	public void CalcButtonDesign()
	{
		driver.navigate().refresh();
		WebElement ButtonCalc = driver.findElement(By.id("calculate_data"));
		int Width = ButtonCalc.getSize().getWidth();
		int Height = ButtonCalc.getSize().getHeight();
		int xVal = ButtonCalc.getLocation().getX();
		int yVal = ButtonCalc.getLocation().getY();
		System.out.println(Width);
		System.out.println(Height);
		System.out.println(xVal);
		System.out.println(yVal);
		String TagNameVal = ButtonCalc.getTagName();
		String ButtonText = ButtonCalc.getAttribute("value");
		WebElement hideMessage = driver.findElement(By.id("new_input"));

		assertEquals(Width, 133);
		assertEquals(Height, 36);
		assertEquals(xVal, 523);
		assertEquals(yVal, 259);
		assertTrue(ButtonCalc.isDisplayed());
		assertTrue(ButtonCalc.isEnabled());
		assertFalse(ButtonCalc.isSelected());
		assertEquals(TagNameVal, "input");
		assertEquals(ButtonText, "Calculate BMI");
		assertFalse(hideMessage.isDisplayed()); 
		}
}
