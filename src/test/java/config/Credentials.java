package config;
import org.aeonbits.owner.ConfigFactory;


public class Credentials {
    public static EmulatorConfig configEmulator = ConfigFactory.create(EmulatorConfig.class, System.getProperties());
}