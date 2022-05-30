package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
//    @Override
//    public WebDriver createDriver(Capabilities caps) {
//
//        // Set your access credentials
//        caps.setCapability("browserstack.user", "tatianacheb_71ptxZ");
//        caps.setCapability("browserstack.key", "DFyfUSBrCigWBM9ogcxs");
//
//        // Set URL of the application under test
//        caps.setCapability("app", "DFyfUSBrCigWBM9ogcxs");
//
//        // Specify device and os_version for testing
//        caps.setCapability("device", "Google Pixel 3");
//        caps.setCapability("os_version", "9.0");
//
//        // Set other BrowserStack capabilities
//        caps.setCapability("project", "Second Java Project");
//        caps.setCapability("build", "browserstack-build-1");
//        caps.setCapability("name", "test_new_app_wiki");
//
//
//        return new AndroidDriver(getBrowserstackUrl(), caps);
//    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
//        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", Credentials.configBrowserstack.appiumVersion());
        mutableCapabilities.setCapability("browserstack.user", "tatianacheb_71ptxZ");
        mutableCapabilities.setCapability("browserstack.key", "DFyfUSBrCigWBM9ogcxs");
        mutableCapabilities.setCapability("browserstack.app", "bs://b4f0d760d412ee47f036323fb433943485d2a130");
//        mutableCapabilities.setCapability("browserstack.user", Credentials.configBrowserstack.user());
//        mutableCapabilities.setCapability("browserstack.key", Credentials.configBrowserstack.key());
//        mutableCapabilities.setCapability("app", Credentials.configBrowserstack.app());
        mutableCapabilities.setCapability("deviceName", Credentials.configBrowserstack.deviceName());
        mutableCapabilities.setCapability("platformName", Credentials.configBrowserstack.platformName());
        mutableCapabilities.setCapability("platformVersion", Credentials.configBrowserstack.platformVersion());
        mutableCapabilities.setCapability("projectName", Credentials.configBrowserstack.projectName());
        mutableCapabilities.setCapability("buildName", Credentials.configBrowserstack.buildName());
        mutableCapabilities.setCapability("testName", Credentials.configBrowserstack.testName());

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

}