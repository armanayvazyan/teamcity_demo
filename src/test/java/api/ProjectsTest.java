package api;

import api.listeners.ErrorFilter;
import api.service.ProjectService;
import api.service.VCSRootsService;
import config.AuthMethod;
import config.Configurations;
import config.VCSName;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utils.TestUtils;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ProjectsTest {

    @BeforeEach
    void init() {
        RestAssured.filters(new ErrorFilter());
    }

    private final String projectName = TestUtils.generateProjectName();
    private final String projectId = TestUtils.generateProjectId(projectName);
    private final String name = Configurations.VCS_REPO_URL.substring(Configurations.VCS_REPO_URL.lastIndexOf("/") + 1);
    private final String vcsId =  projectName + "_" + name.substring(0, 1).toUpperCase() + name.substring(1);


    @Test
    void createProjectFromVCS() {
        ProjectService.create(projectName, projectId, "_Root", true)
                .then()
                .statusCode(200);

        VCSRootsService.create(vcsId, name, VCSName.GIT, projectId, "main", Configurations.VCS_REPO_URL, AuthMethod.PASSWORD, Configurations.VCS_USERNAME, Configurations.VCS_PASSWORD)
                .then()
                .statusCode(200);
    }

    @AfterEach
    void removeGeneratedData() {
        VCSRootsService.delete(vcsId);
        ProjectService.delete(projectId);
    }
}
