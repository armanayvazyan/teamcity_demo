package utils;

import java.util.concurrent.ThreadLocalRandom;

public class TestUtils {

    public static String generateProjectName() {
        return "testProj" + ThreadLocalRandom.current().nextInt(10_000, 99_999);
    }

    public static String generateProjectId(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
