package dataAccess.exceptions;

public class SupprimerCandidatException extends IllegalArgumentException {
    public SupprimerCandidatException(Exception e) {
        super(e);
    }
}
