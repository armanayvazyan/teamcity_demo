import config.Configurations;
import constants.AgentState;
import data.AgentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.OverViewPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentsTest extends BaseTest{

    @BeforeEach
    void loginUser() {
        new LoginPage().open()
                .setUsername(Configurations.TC_USERNAME)
                .setPassword(Configurations.TC_PASSWORD)
                .clickLoginButton();
    }

    @Test
    void navigationToAgentsPage() {
        var agentsPage = new OverViewPage().open().clickAgentsTab();
        assertEquals(agentsPage.getCurrentUrl(), agentsPage.getPageUrl());
    }

    @Test
    void activeAgentsCountCheck() {
        var overViewPage = new OverViewPage().open();
        var activeAgentsCount = overViewPage.getActiveAgentsCount();

        var agentsPage = overViewPage.clickAgentsTab();
        assertEquals(agentsPage.getAgentsCount(AgentState.CONNECTED), activeAgentsCount, "Count didn't match");
    }

    @ParameterizedTest
    @MethodSource("data.AgentsProvider#agentCountProvider")
    void countOfAgentsInDifferentStates(AgentState agentState, int count) {
        var overViewPage = new OverViewPage().open();
        var agentsPage = overViewPage.clickAgentsTab();
        assertEquals(agentsPage.getAgentsCount(agentState), count, "Count didn't match");
    }
}
