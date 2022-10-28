package api.service;

import config.Configurations;
import config.URL;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {

    @SneakyThrows(ClassNotFoundException.class)
    private static RequestSpecification request() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        String path = Class.forName(className).getAnnotation(URL.class).value();
        return given().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .log()
                .uri()
                .header(new Header("Origin", Configurations.BASE_URL))
                .auth()
                .basic("", Configurations.TC_ADMIN_TOKEN)
                .baseUri(Configurations.BASE_URL)
                .basePath(path);
    }

    protected static Response post(Map<String, Object> bodyParams) {
        return request().body(bodyParams).post();
    }
    protected static Response delete(String resourceLocator) {
        return request().delete("/" + resourceLocator);
    }
}
