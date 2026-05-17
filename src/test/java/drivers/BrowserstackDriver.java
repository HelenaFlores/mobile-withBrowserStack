package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.web.MobileConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.aeonbits.owner.ConfigFactory;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
        @Nonnull
        @Override
        public WebDriver createDriver(@Nonnull Capabilities capabilities) {
            MutableCapabilities caps = new MutableCapabilities();
            MobileConfig config = ConfigFactory.create(MobileConfig.class);

            caps.setCapability("browserstack.user", config.getBrowserstackUser());
            caps.setCapability("browserstack.key", config.getBrowserstackKey());

            caps.setCapability("app", config.getBrowserstackApp());

            caps.setCapability("device", config.getDevice());
            caps.setCapability("os_version", config.getOsVersion());

            caps.setCapability("project", config.getProject());
            caps.setCapability("build", config.getBuild());
            caps.setCapability("name", config.getTestName());

            try {
                return new RemoteWebDriver(
                        new URL(config.getRemoteUrl()), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }