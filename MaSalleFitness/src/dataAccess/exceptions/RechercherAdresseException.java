package dataAccess.exceptions;

public class RechercherAdresseException extends IllegalArgumentException {
    public RechercherAdresseException(Exception e) {
        super(e);
    }
}
