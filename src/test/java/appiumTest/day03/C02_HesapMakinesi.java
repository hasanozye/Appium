package appiumTest.day03;

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

public class C02_HesapMakinesi {
    @Test
    public void calcTest() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement sekiz = driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        sekiz.click();

        WebElement carpı = driver.findElement(By.id("com.android.calculator2:id/op_mul"));
        carpı.click();

        WebElement yedi = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        yedi.click();

        WebElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));
        equals.click();

        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        System.out.println("result = " + result.getText());

        Assert.assertTrue(result.equals("56"));


    }
}
