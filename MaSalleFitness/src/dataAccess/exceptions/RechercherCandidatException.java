package dataAccess.exceptions;

public class RechercherCandidatException extends IllegalArgumentException {
    public RechercherCandidatException(Exception e) {
        super(e);
    }
}
