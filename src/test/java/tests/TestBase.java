package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

//    @AfterEach
//    void addAttachments() {
//        String sessionId = Selenide.sessionId().toString();
//        System.out.println(sessionId);
//
////        Attach.screenshotAs("Last screenshot"); // todo fix
//        Attach.pageSource();
//        closeWebDriver();
//
//        //   Attach.addVideo(sessionId);
//    }

    /* in beforeAll
            switch (config.getDeviceHost()) {
            case BROWSERSTACK -> {
                Configuration.browser = BrowserstackDriver.class.getName();
                Configuration.browserSize = null;
                Configuration.timeout = 30000;
            }
            case REAL -> {
                // Пока не реализовано — бросаем исключение
                throw new UnsupportedOperationException("REAL device not implemented yet");
            }
            case EMULATION -> {
                // Пока не реализовано — бросаем исключение
                throw new UnsupportedOperationException("EMULATION not implemented yet");
            }
        }
     */
}
