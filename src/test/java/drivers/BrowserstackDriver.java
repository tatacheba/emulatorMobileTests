package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.OwnerConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.appium_version", OwnerConfig.config.appiumVersion());
        mutableCapabilities.setCapability("browserstack.user", OwnerConfig.config.user());
        mutableCapabilities.setCapability("browserstack.key", OwnerConfig.config.key());
        mutableCapabilities.setCapability("app", OwnerConfig.config.app());
        mutableCapabilities.setCapability("device", OwnerConfig.config.deviceName());
        mutableCapabilities.setCapability("os_version", OwnerConfig.config.platformVersion());
        mutableCapabilities.setCapability("project", OwnerConfig.config.projectName());
        mutableCapabilities.setCapability("build", OwnerConfig.config.buildName());
        mutableCapabilities.setCapability("name", OwnerConfig.config.testName());

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(OwnerConfig.config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}