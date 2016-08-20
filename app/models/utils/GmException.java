package models.utils;

public class GmException extends Exception {

    public GmException() {
    }

    public GmException(String message) {
        super(message);
    }

    public GmException(String message, Throwable cause) {
        super(message, cause);
    }

    public GmException(Throwable cause) {
        super(cause);
    }
}
