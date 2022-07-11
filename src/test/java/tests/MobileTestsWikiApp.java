package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MobileTestsWikiApp extends TestBase {

    @Test
    @Owner("TataCheba")
    @DisplayName("App onboarding pass")
    void checkOnboardingPage() {
        step("Go to first Welcome Page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("The Free Encyclopedia …in over 300 languages"));
        });
        step("Go to Second Welcome Page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("New ways to explore"));
        });
        step("Go to Third Welcome Page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("Reading lists with sync"));
        });
        step("Go to Fourth Welcome Page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("Send anonymous data"));
        });
    }

    @Owner("TataCheba")
    @Test
    @DisplayName("Trying to find information about some interesting persons.")
    void searchTest() {
        step("Looking for Chris Evans", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("Chris Evans");
            $$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(sizeGreaterThan(0));
        });

        step("Go back for new search", () ->
        {
            step("Go back", () -> back());
            step("Again Go back", () -> back());
        });

        step("Looking for Captain America", () ->
        {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("Captain America");
            $$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }
}
