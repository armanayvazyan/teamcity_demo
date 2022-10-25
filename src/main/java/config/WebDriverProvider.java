package config;

import org.openqa.selenium.WebDriver;

public class WebDriverProvider {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static synchronized void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
