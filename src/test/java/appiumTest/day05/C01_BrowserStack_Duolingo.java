package appiumTest.day05;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C01_BrowserStack_Duolingo {
    public static String userName = "hasanzyer_mlEPWi";
    public static String accesKey = "WMWMJMngQUMapc7mKPsw";

    //https://www.browserstack.com/app-automate/capabilities
    @Test
    public void browserStackTest01() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "11.0");
        capabilities.setCapability("device", "Samsung Galaxy M52");
        capabilities.setCapability("app", "bs://546ce96c1f7fd5b20de53ed38f35a32f577b6352");
        capabilities.setCapability("browserstack.debug", "true");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("https://" + userName + ":" + accesKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement getStarted = driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        System.out.println("Get Started Element Text : " + getStarted.getText());
        getStarted.click();

        WebElement english = driver.findElement(By.xpath("//*[@text=\"English\"]"));
        english.click();

        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Turkish\"));");

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
