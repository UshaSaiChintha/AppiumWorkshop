import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesRegex;

public class RealDeviceDesiredCapabilitiesForHybridApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Android Device");
        desiredCapabilities.setCapability("appium:app", System.getProperty("user.dir") +"/Apps/TheApp-v1.10.0.apk");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);

        androidDriver.findElementByAccessibilityId("Webview Demo").click();
        androidDriver.findElementByAccessibilityId("urlInput").sendKeys("https://appiumpro.com");
        androidDriver.findElementByAndroidUIAutomator("textContains(\"Go\")").click();

        Thread.sleep(2000);
        System.out.println("Page Title is " + androidDriver.findElementByClassName("android.webkit.WebView").getText());
    }
}
