package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OverViewPage extends BasePage<OverViewPage> {

    @FindBy(id = "overviewMain")
    private WebElement overViewRootElement;

    @FindBy(css = "[title='Agents']")
    private WebElement agentsTab;

    @FindBy(css = " [class*='buildTypeName']")
    private List<WebElement> buildTypes;
    @FindBy(css = "[data-hint-container-id='header-agents-active']")
    private WebElement activeAgentsCount;

    @Override
    protected WebElement getPageLoadedIndicatorSelector() {
        return overViewRootElement;
    }

    @Override
    protected String getPath() {
        return "/overview.html";
    }

    public AgentsPage clickAgentsTab() {
        click(agentsTab);
        return new AgentsPage().init();
    }

    public int getActiveAgentsCount() {
        return Integer.parseInt(getText(activeAgentsCount));
    }

    public void clickOnBuildType(int index) {
        click(buildTypes, index);
    }
}
