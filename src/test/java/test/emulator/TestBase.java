package test.emulator;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import drivers.EmulatorMobileDriver;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private static final String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = null;

        switch (System.getProperty("device")) {
            case "emulator":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "real":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            default:
                throw new IllegalArgumentException("You need to choose between real, emulator, browserstack");
        }

    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();
        // Attach.video(sessionId);//not supported by Emulator
    }
}
