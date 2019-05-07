package dataAccess.exceptions;

public class RechercheException extends IllegalArgumentException {
    public RechercheException(Exception e) {
        super(e);
    }
}
