package config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:emulator.properties"})
public interface EmulatorConfig extends Config {
    String user();
    String key();
    String app();
    String url();
    String appiumVersion();
    String deviceName();
    String platformName();
    String platformVersion();
    String projectName();
    String buildName();
    String testName();
}