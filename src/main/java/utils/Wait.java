package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

import static config.WebDriverProvider.getDriver;

public class Wait {
    private static final WebDriverWait wait;

    static {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10), Duration.ofMillis(500));
    }

    public static WebElement _for(Function<? super WebDriver, WebElement> isTrue) {
        return wait.until(isTrue);
    }
}
