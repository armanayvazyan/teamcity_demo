package api.service;

import config.URL;
import io.restassured.response.Response;

import java.util.Map;

@URL("/app/rest/projects")
public class ProjectService extends BaseService {

    public static Response create(String name, String id, String parentProject, boolean copyAllAssociatedSettings) {
        Map<String, Object> body = Map.of(
                "parentProject", Map.of("locator", parentProject),
                "name",name,
                "id",id,
                "copyAllAssociatedSettings", copyAllAssociatedSettings
        );
        return post(body);
    }

    public static Response delete(String id) {
        return BaseService.delete(id);
    }
}
