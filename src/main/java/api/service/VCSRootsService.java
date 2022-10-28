package api.service;

import api.model.Property;
import config.AuthMethod;
import config.URL;
import config.VCSName;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

@URL("/app/rest/vcs-roots")
public class VCSRootsService extends BaseService{

    public static Response create(String id, String name, VCSName vcsName, String projectId, String branch, String url, AuthMethod authMethod, String username, String password) {
        Map<String, Object> body = Map.of(
                "name",name,
                "id",id,
                "vcsName", vcsName.getValue(),
                "project", Map.of(
                        "id", projectId
                ),
                "properties", Map.of(
                        "property", List.of(
                                new Property("authMethod", authMethod.name()),
                                new Property("username", username),
                                new Property("password", password),
                                new Property("branch", branch),
                                new Property("url", url)
                        )
        )
        );
        return post(body);
    }

    public static Response delete(String id) {
        return BaseService.delete(id);
    }
}
