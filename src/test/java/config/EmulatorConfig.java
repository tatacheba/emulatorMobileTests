package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentialsEmulatorExample.properties"})
public interface EmulatorConfig extends Config {
    String deviceName();
    String platformName();
    String platformVersion();
    String appUrl();
    String urlLocalHost();
}
