//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Launch {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AllowPopup";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e52cf213");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.infinityar.turret");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.unity3d.player.UnityPlayerNativeActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void AllowPopup() {
    	//driver.launchApp();
    	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//*[@id='workspace']")).click();
        //driver.swipe(1833, 437, 1833, -29, 1149);
        //driver.swipe(2074, 533, 2074, 648, 1489);
        //driver.findElement(By.xpath("//*[@text='Turret']")).click();
        driver.findElement(By.id("permission_allow_button")).click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(By.id("permission_allow_button")).click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.closeApp();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.launchApp();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.closeApp();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}