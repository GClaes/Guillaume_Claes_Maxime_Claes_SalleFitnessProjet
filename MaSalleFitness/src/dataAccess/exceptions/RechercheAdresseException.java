package dataAccess.exceptions;

public class RechercheAdresseException extends IllegalArgumentException {
    public RechercheAdresseException(Exception e) {
        super(e);
    }
}
