package appiumTest.day04;

import java.net.URL;
import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C01_BrowserStackSample {
    public static String userName = "hasanzyer_mlEPWi";
    public static String accesKey = "WMWMJMngQUMapc7mKPsw";


    @Test
    public void browserStackTest01() throws MalformedURLException {
        // Use Java Client v6.0.0 or above
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("app", "bs://546ce96c1f7fd5b20de53ed38f35a32f577b6352");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("https://" + userName + ":" + accesKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);

        //AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);


    }
}
