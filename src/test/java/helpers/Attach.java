package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Attach {
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        try {
            File screenshot = Selenide.screenshot(OutputType.FILE);
            if (screenshot == null) {
                System.out.println("Screenshot file is null");
                return new byte[0];
            }
            return Files.readAllBytes(screenshot.toPath());
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
            return new byte[0];
        }
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + Browserstack.videoUrl(sessionId)
                + "' type='video/mp4'></video></body></html>";
    }
}