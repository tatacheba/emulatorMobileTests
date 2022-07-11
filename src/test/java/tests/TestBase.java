package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Credentials;
import drivers.BrowserstackMobileDriver;
import drivers.EmulatorMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.ExecutionException;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Attach.getSessionId;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static java.lang.System.getProperty;

public class TestBase {
    public static String devHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {

        switch (devHost) {
            case "emulator":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            default:
                throw new IllegalArgumentException("need choose deviceHost");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (devHost == "browserstack") {
            Attach.video(sessionId);
        }
        Selenide.closeWebDriver();
    }
}
