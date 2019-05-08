package dataAccess.exceptions;

public class CoachExisteException extends IllegalArgumentException {
    public CoachExisteException(Exception e) {
        super(e);
    }
}
