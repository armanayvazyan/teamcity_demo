package utils;

import exceptions.AccessTokenNotFoundException;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtils {

    @SneakyThrows
    public static String readAdminTokenFromServerLogs() {
        String file = "C:\\TeamCity\\logs\\teamcity-server.log";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains("Super user authentication token")) {
                    return currentLine.substring(currentLine.indexOf("Super user authentication token: ") + 33, currentLine.indexOf("(use") -1 );
                }
            }
        }
        throw new AccessTokenNotFoundException();
    }
}
