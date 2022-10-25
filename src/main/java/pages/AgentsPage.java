package pages;

import constants.AgentState;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AgentsPage extends BasePage<AgentsPage>{

    @FindBy(id = "agentsPanel")
    private WebElement agentsPanelRootElement;

    @FindBy(id ="description")
    private WebElement agentsDescription;

    @FindBy(css = "#registeredAgents_Tab  .tabCounter")
    private WebElement connectedCount;

    @FindBy(css = "#unregisteredAgents_Tab  .tabCounter")
    private WebElement disconnectedCount;

    @FindBy(css = "#unauthorizedAgents_Tab  .tabCounter")
    private WebElement unauthorizedCount;

    @Override
    protected WebElement getPageLoadedIndicatorSelector() {
        return agentsPanelRootElement;
    }

    @Override
    protected String getPath() {
        return "/agents.html";
    }

    public int getAgentsCount(AgentState state) {
        switch (state) {
            case CONNECTED: return Integer.parseInt(getText(connectedCount));
            case DISCONNECTED: return Integer.parseInt(getText(disconnectedCount));
            case UNAUTHORIZED: return Integer.parseInt(getText(unauthorizedCount));
            default: throw new InvalidArgumentException("Wrong state was passed");
        }
    }
}
