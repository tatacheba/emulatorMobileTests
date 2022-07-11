package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentialsBrowserstackExample.properties"})
public interface BrowserstackConfig extends Config {
    String user();
    String key();
    String app();
    String url();
}
