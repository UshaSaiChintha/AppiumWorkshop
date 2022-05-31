import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EmulatorDesiredCapabilities {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "APPIUM_EMULATOR");
        desiredCapabilities.setCapability("appium:app", System.getProperty("user.dir") + "/Apps/VodQA.apk");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:packageName", "com.vodqareactnative");
        desiredCapabilities.setCapability("appium:activityName", "com.vodqareactnative/.MainActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
    }
}
