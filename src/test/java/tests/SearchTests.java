package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            $(id("fragment_onboarding_skip_button")).click();
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia:id/fragment_search_results"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void successfulSearchWithOpenArticleTest() {
        step("Type search", () -> {
            $(id("fragment_onboarding_skip_button")).click();
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia:id/search_src_text")).sendKeys("Mars");
            $$(id("org.wikipedia:id/fragment_search_results")).get(0).click();
            $(id("org.wikipedia:id/closeButton")).click();
        });

        step("Verify article opened", () -> {
            $(id("org.wikipedia:id/page_contents_container")).shouldHave(Condition.visible);
        });
    }
}