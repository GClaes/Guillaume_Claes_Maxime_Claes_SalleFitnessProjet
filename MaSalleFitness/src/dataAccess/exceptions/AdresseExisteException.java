package dataAccess.exceptions;

public class AdresseExisteException extends IllegalArgumentException {
    public AdresseExisteException(Exception e) {
        super(e);
    }
}
