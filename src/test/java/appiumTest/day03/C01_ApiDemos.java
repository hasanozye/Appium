package appiumTest.day03;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_ApiDemos {
    @Test
    public void ApiDemosTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\PC\\IdeaProjects\\com.GuiderSoftAppium\\src\\app\\apidemos.apk");


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement accept = driver.findElement(By.xpath("//*[@text=\"Views\"]"));
        accept.click();

        WebElement expandableLists = driver.findElement(By.xpath("//*[@text=\"Expandable Lists\"]"));
        expandableLists.click();

        WebElement firstCustomAdapter = driver.findElement(By.xpath("//*[@text=\"1. Custom Adapter\"]"));
        firstCustomAdapter.click();

        WebElement peopleName = driver.findElement(By.xpath("//*[@text=\"People Names\"]"));
        peopleName.click();

        List<AndroidElement> list = driver.findElements(By.className("android.widget.TextView"));

        for (int i = 2; i < 6; i++) {
            System.out.println(list.get(i).getText());

        }
    }

    @Test
    public void ApiDemostest02() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\PC\\IdeaProjects\\com.GuiderSoftAppium\\src\\app\\apidemos.apk");


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement preference = driver.findElement(By.xpath("//*[@text=\"Preference\"]"));
        preference.click();

        WebElement dependincies = driver.findElement(By.xpath("//*[@text=\"3. Preference dependencies\"]"));
        dependincies.click();

        WebElement checkBox = driver.findElement(By.xpath("(//*[@class=\"android.widget.RelativeLayout\"])[1]"));
        checkBox.click();

        WebElement wifiSettings = driver.findElement(By.xpath("//*[@text=\"WiFi settings\"]"));
        wifiSettings.click();

        WebElement edit = driver.findElement(By.id("android:id/edit"));
        edit.click();

        edit.sendKeys("Appium çok güzel");

        WebElement okButton = driver.findElement(By.id("android:id/button1"));
        okButton.click();

        Thread.sleep(2000);
        wifiSettings.click();

        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("//*[@text=\"Appium çok güzel\"]"));
        String realText = text.getText();

        Assert.assertTrue(realText.equals("Appium çok güzel"));
        System.out.println("text = " + realText);


    }
}
