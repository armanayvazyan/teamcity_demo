package config;

import com.google.common.io.Resources;

import java.io.IOException;
import java.util.Properties;

public class Configurations {

    private Configurations() {
    }
    public static final String BASE_URL;
    public static final String BROWSER_TYPE;
    public static final String TC_USERNAME;
    public static final String TC_PASSWORD;
    public static final String TC_ADMIN_TOKEN;

    private static final Properties configs;

    static {
        configs = readFromFile("/config.properties");
        BASE_URL = getProperty("base.url");
        TC_USERNAME = getProperty("tc.username");
        TC_PASSWORD = getProperty("tc.password");
        TC_ADMIN_TOKEN = getProperty("tc.admin.token");
        BROWSER_TYPE = getProperty("browser.type");
    }

    public static String getProperty(String key) {
        if (System.getProperty(key) == null || System.getProperty(key).isEmpty()) {
            String property = configs.getProperty(key);
            System.out.println("Getting property " + key + ": " + property);
            return property;
        } else {
            String property = System.getProperty(key);
            System.out.println("Getting property " + key + ": " + property);
            return property;
        }
    }

    private static Properties readFromFile(String path) {
        Properties properties = new Properties();
        try {
            properties.load(Resources.class.getResourceAsStream(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return properties;
    }


}