package dataAccess.exceptions;

public class SingletonConnectionException extends RuntimeException {
    public SingletonConnectionException(Exception e) {
        super(e);
    }
}
