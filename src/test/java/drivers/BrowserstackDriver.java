package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
        @Nonnull
        @Override
        public WebDriver createDriver(@Nonnull Capabilities capabilities) {
            MutableCapabilities caps = new MutableCapabilities();

            // Set your access credentials
            caps.setCapability("browserstack.user", "bsuser_HRrmko");
            caps.setCapability("browserstack.key", "x6DRwo1GGHfek7rCVbpV");

            // Set URL of the application under test
            caps.setCapability("app", "bs://f8c04b4a37220120b29f9e3bb82209511ef3f054");

            // Specify device and os_version for testing
            caps.setCapability("device", "Samsung Galaxy S22 Ultra");
            caps.setCapability("os_version", "12.0");

            // Set other BrowserStack capabilities
            caps.setCapability("project", "First Java Project");
            caps.setCapability("build", "browserstack-build-1");
            caps.setCapability("name", "first_test");

            // Initialise the remote Webdriver using BrowserStack remote URL
            // and desired capabilities defined above
            try {
                return new RemoteWebDriver(
                        new URL("https://hub.browserstack.com/wd/hub"), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }