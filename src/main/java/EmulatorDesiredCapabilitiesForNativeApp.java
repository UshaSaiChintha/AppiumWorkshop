import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EmulatorDesiredCapabilitiesForNativeApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "APPIUM_EMULATOR");
        desiredCapabilities.setCapability("appium:app", System.getProperty("user.dir") + "/Apps/VodQA.apk");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:packageName", "com.vodqareactnative");
        desiredCapabilities.setCapability("appium:activityName", "com.vodqareactnative/.MainActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);

        androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc='login']").click();

        Thread.sleep(2000);
        androidDriver.findElementByXPath("//*[@text='Chained View']").click();

        Thread.sleep(2000);
        List<WebElement> viewElements = androidDriver.findElementsByClassName("android.widget.TextView");

        assertThat(viewElements.get(0).getText(), is("Hello World, I'm View one "));
        assertThat(viewElements.get(1).getText(), is("Hello World, I'm View two "));
        assertThat(viewElements.get(2).getText(), is("Hello World, I'm View three "));
    }


}
