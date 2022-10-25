package data;

import constants.AgentState;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class AgentsProvider {

    public static Stream<Arguments> agentCountProvider() {
        return Stream.of(
                Arguments.of(AgentState.CONNECTED, 1),
                Arguments.of(AgentState.DISCONNECTED, 0),
                Arguments.of(AgentState.UNAUTHORIZED, 0)
        );
    }
}
