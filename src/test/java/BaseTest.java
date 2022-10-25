import config.WebDriverProvider;
import config.WebDriverType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static config.WebDriverProvider.getDriver;

@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class BaseTest {

    @BeforeEach
    void init() {
        WebDriverProvider.setDriver(WebDriverType.initWebDriver());
    }

    @AfterEach
    void tearDown() {
        getDriver().quit();
    }

}
