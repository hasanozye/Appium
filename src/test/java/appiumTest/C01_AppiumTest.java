package appiumTest;

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

public class C01_AppiumTest {
    @Test
    public void test01() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
        //todo emulator -list-avds => cihaz ismini de bu kod sayesinde buluruz.
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        //todo adb shell getprop ro.build.version.release => version bulmak için
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\PC\\IdeaProjectsU\\com.GuiderSoftAppium\\src\\app\\Duolingo.apk");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        WebElement getStart = driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        String getaText = getStart.getText();
        System.out.println("getaText = " + getaText);
        getStart.click();

        WebElement english = driver.findElement(By.xpath("//*[@text=\"English\"]"));
        english.click();

        WebElement turksh = driver.findElement(By.xpath("//*[@text=\"Turkish\"]"));
        turksh.click();

        WebElement willOk = driver.findElement(By.id("android:id/button1"));
        willOk.click();

        WebElement okul = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"school\"]/android.widget.TextView"));
        okul.click();

        WebElement ciddi = driver.findElement(By.xpath("//*[@text=\"günde 15 dakika\"]"));
        ciddi.click();

        driver.findElement(By.id("com.duolingo:id/xpGoalContinueButton")).click();
        driver.findElement(By.id("driver.findElement(By.id(\"\"))\n")).click();

        WebElement testBasla = driver.findElement(By.id("com.duolingo:id/primaryButton"));
        Assert.assertTrue(testBasla.isDisplayed());
        System.out.println("testBasla.getText() = " + testBasla.getText());
        testBasla.click();

        WebElement skip = driver.findElement(By.id("com.duolingo:id/skipButton"));
        Assert.assertTrue(skip.isDisplayed());


    }

}