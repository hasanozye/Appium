package day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
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

        List <AndroidElement> list = driver.findElements(By.className("android.widget.TextView"));

        for (int i = 2; i < 6 ; i++) {
            System.out.println(list.get(i).getText());
        }

        /*String first = driver.findElement(By.xpath("//*[@text=\"Arnold\"]")).getText();
        System.out.println("first = " + first);

        String second = driver.findElement(By.xpath("//*[@text=\"Barry\"]")).getText();
        System.out.println("second = " + second);

        String third = driver.findElement(By.xpath("//*[@text=\"Chuck\"]")).getText();
        System.out.println("third = " + third);

        String fourth = driver.findElement(By.xpath("//*[@text=\"David\"]")).getText();
        System.out.println("fourth = " + fourth);

         */


    }
}
