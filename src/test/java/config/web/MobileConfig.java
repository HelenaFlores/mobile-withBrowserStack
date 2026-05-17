package config.web;

import config.Host;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({
            "system:properties",
            "classpath:${deviceHost}.properties"
    })

    public interface MobileConfig extends Config {

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();

    @Key("host")
    @DefaultValue("BROWSERSTACK")
    Host getDeviceHost();

    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("browserstack.app")
    String getBrowserstackApp();

    @Key("browserstack.device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("browserstack.osVersion")
    @DefaultValue("12.0")
    String getOsVersion();

    @Key("browserstack.project")
    @DefaultValue("First Java Project")
    String getProject();

    @Key("browserstack.build")
    @DefaultValue("browserstack-build-1")
    String getBuild();

    @Key("browserstack.name")
    @DefaultValue("first_test")
    String getTestName();
}
