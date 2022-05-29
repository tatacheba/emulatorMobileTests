package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:browserstack.properties"})
public interface BrowserstackConfig extends Config {
    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("url")
    String url();

    @Key("appiumVersion")
    String appiumVersion();

    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("projectName")
    String projectName();

    @Key("buildName")
    String buildName();

    @Key("testName")
    String testName();
}