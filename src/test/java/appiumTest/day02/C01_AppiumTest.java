package appiumTest.day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class C01_AppiumTest {
    @Test
    public void testAppium01() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
        // cmd'ye emulator -list-avds => cihaz ismini bu kod sayesinde buluruz.
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        // cmd'ye adb shell getprop ro.build.version.release => version bulmak için
        // cmd'ye adb shell  settings get secure android_id => cihaz id'si için
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\PC\\IdeaProjects\\com.GuiderSoftAppium\\src\\app\\Duolingo.apk");


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement getStarted = driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        System.out.println("Get Started Element Text : " + getStarted.getText());
        getStarted.click();

        WebElement english = driver.findElement(By.xpath("//*[@text=\"English\"]"));
        english.click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(881, 1870))
                .moveTo(PointOption.point(874, 230))
                .release()
                .perform();

        WebElement turkish = driver.findElement(By.xpath("//*[@text=\"Turkish\"]"));
        turkish.click();

        WebElement okButton = driver.findElement(By.id("android:id/button1"));
        okButton.click();

        WebElement okul = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"school\"]/android.widget.TextView"));
        okul.click();

        WebElement ciddi = driver.findElement(By.xpath("//*[@text=\"günde 15 dakika\"]"));
        ciddi.click();

        driver.findElement(By.id("com.duolingo:id/xpGoalContinueButton")).click();
        driver.findElement(By.id("com.duolingo:id/placementHeader")).click();

        WebElement testBasla = driver.findElement(By.id("com.duolingo:id/primaryButton"));
        Assert.assertTrue(testBasla.isDisplayed());
        System.out.println("testBasla.getText() = " + testBasla.getText());
        testBasla.click();

        WebElement skip = driver.findElement(By.id("com.duolingo:id/skipButton"));
        Assert.assertTrue(skip.isDisplayed());

    }

}