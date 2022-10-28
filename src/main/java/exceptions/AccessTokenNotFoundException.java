package exceptions;

public class AccessTokenNotFoundException extends RuntimeException{
    public AccessTokenNotFoundException() {
        super("Could not find Access Token in Logs");
    }
}
