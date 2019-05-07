package dataAccess.exceptions;

public class RechercherException extends IllegalArgumentException {
    public RechercherException(Exception e) {
        super(e);
    }
}
