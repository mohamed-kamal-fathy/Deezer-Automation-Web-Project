package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// class for Centralizes configuration management.
public class Config {
    private static Properties props;

    static {
        try {
            props = new Properties();
            props.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static String GetProperty(String key) {
        return props.getProperty(key);
    }



    public static String getBaseUrl(){
        return GetProperty("baseUrl");
    }
    
    public static  String getBrowser(){
        return GetProperty("browser");
    }

    
}