package api;

import api.listeners.ErrorFilter;
import api.service.ProjectService;
import api.service.VCSRootsService;
import config.Configurations;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import utils.FileUtils;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class BaseTest {

    @BeforeAll
    static void getAccessToken() {
        Configurations.TC_ADMIN_TOKEN = FileUtils.readAdminTokenFromServerLogs();;
    }

    @BeforeEach
    void init() {
        RestAssured.filters(new ErrorFilter());
    }
}
