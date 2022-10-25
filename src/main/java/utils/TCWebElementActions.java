package utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public interface TCWebElementActions {

    default void click(WebElement element) {
        Wait._for(ExpectedConditions.elementToBeClickable(element)).click();
    }

    default void click(List<WebElement> element, int index) {
        Wait._for(ExpectedConditions.elementToBeClickable(element.get(index)));
        element.get(index).click();
    }

    default void setText(WebElement element, String text) {
        var webElement = Wait._for(ExpectedConditions.elementToBeClickable(element));
        webElement.clear();
        webElement.sendKeys(text);
    }

    default String getText(WebElement element) {
        return Wait._for(ExpectedConditions.visibilityOf(element)).getText();
    }

    default boolean isElementDisplayed(WebElement element) {
        try {
            Wait._for(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
