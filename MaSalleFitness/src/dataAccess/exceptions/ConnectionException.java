package dataAccess.exceptions;

public class ConnectionException extends IllegalArgumentException {
    public ConnectionException(Exception e) {
        super(e);
    }
}
