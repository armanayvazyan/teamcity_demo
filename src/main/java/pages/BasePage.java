package pages;

import config.Configurations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.TCWebElementActions;

import static config.WebDriverProvider.getDriver;

public abstract class BasePage<T> extends LoadableComponent<BasePage<T>> implements TCWebElementActions {

    public BasePage() {
    }

    public T open() {
        PageFactory.initElements(getDriver(), this);
        return (T)get();
    }

    protected T init() {
        PageFactory.initElements(getDriver(), this);
        isLoaded();
        return (T)this;
    }

    @Override
    protected void load() {
        getDriver().get(Configurations.BASE_URL + getPath());
    }

    @Override
    protected void isLoaded() throws Error {
        if(!isElementDisplayed(getPageLoadedIndicatorSelector())){
            throw new AssertionError(getClass().getSimpleName() + " is not loaded as unable to locate " + getPageLoadedIndicatorSelector().toString());
        }
    }

    protected abstract WebElement getPageLoadedIndicatorSelector();

    protected abstract String getPath();

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getPageUrl() {
        return Configurations.BASE_URL + getPath();
    }
}
