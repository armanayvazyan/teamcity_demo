package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum WebDriverType implements IDriverType {

    CHROME {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opt = new ChromeOptions();
            opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            return new ChromeDriver(opt);
        }
    },
    EDGE {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    };

    public static synchronized WebDriver initWebDriver() {
        switch (Configurations.BROWSER_TYPE) {
            case "chrome": return CHROME.createDriver();
            case "firefox": return FIREFOX.createDriver();
            case "edge": return EDGE.createDriver();
            default: throw new InvalidArgumentException("Wrong driver type was passed");
        }
    }
}
