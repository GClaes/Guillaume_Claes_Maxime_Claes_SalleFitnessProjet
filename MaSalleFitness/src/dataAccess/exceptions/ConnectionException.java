package dataAccess.exceptions;

public class ConnectionException extends Exception {
    public ConnectionException(Exception e) {
        super(e);
    }
}
