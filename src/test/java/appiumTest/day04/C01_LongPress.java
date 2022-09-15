package appiumTest.day04;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C01_LongPress {
    @Test
    public void LongPressTest() throws MalformedURLException, InterruptedException {
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

        WebElement expandableLists = driver.findElement(By.xpath("//*[@text=\"Expandable Lists\"]"));
        expandableLists.click();

        WebElement firstCustomAdapter = driver.findElement(By.xpath("//*[@text=\"1. Custom Adapter\"]"));
        firstCustomAdapter.click();
        Thread.sleep(3000);

        WebElement peopleNames = driver.findElement(By.xpath("//*[@text=\"People Names\"]"));

        TouchAction touchAction = new TouchAction(driver);

        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNames)).withDuration(Duration.ofSeconds(3))).perform();
        WebElement action = driver.findElement(By.xpath("//*[@text=\"Sample action\"]"));
        action.click();


        /*List<AndroidElement> list = driver.findElements(By.className("android.widget.TextView"));

        for (int i = 2; i < 6; i++) {
            System.out.println(list.get(i).getText());

        }

         */
    }
}
