package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {
    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);
    public static EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);
}

