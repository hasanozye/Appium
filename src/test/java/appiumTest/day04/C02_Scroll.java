package appiumTest.day04;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C02_Scroll {
    @Test
    public void scrollTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\PC\\IdeaProjects\\com.GuiderSoftAppium\\src\\app\\apidemos.apk");


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement accept = driver.findElement(By.xpath("//*[@text=\"Views\"]"));
        accept.click();

        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
        driver.findElement(By.xpath("//*[@text=\"WebView\"]")).click();

        driver.findElement(By.xpath("(//*[@class=\"android.view.View\"]) [3]")).click();

        String text =driver.findElement(By.className("android.widget.EditText")).getText();
        System.out.println("text = " + text);
        Assert.assertTrue(text.equals("i has no focus"));



    }
}
