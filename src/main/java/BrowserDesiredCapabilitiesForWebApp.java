import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesRegex;

public class BrowserDesiredCapabilitiesForWebApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Anything");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("browserName", "Chrome");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);

        Thread.sleep(2000);
        androidDriver.get("https://facebook.com");

        Thread.sleep(2000);
        System.out.println(androidDriver.getPageSource());
        androidDriver.findElementById("m_login_email").sendKeys("random");
        androidDriver.findElementById("m_login_password").sendKeys("1234");
        androidDriver.findElementById("login_password_step_element").click();

        assertThat(androidDriver.findElementById("login_error").getText(), matchesRegex("Sign for an account$"));
    }
}
