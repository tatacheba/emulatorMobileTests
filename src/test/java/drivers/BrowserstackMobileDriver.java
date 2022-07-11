package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCap = new MutableCapabilities();
        mutableCap.merge(capabilities);
        mutableCap.setCapability("browserstack.user", Credentials.browserstackConfig.user());
        mutableCap.setCapability("browserstack.key", Credentials.browserstackConfig.key());
        mutableCap.setCapability("app", Credentials.browserstackConfig.app());
        mutableCap.setCapability("device", "Samsung Galaxy A10");
        mutableCap.setCapability("os_version", "9.0");
        mutableCap.setCapability("project", "Wikipedia App MobileAutotests");
        mutableCap.setCapability("build", "Autotests browserstack");
        mutableCap.setCapability("name", "Test Wikipedia App");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCap);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Credentials.browserstackConfig.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}