package model.exceptions;

public class PrenomException extends IllegalArgumentException {
    private String prenomErrone;

    public PrenomException(String prenomErrone) {
        this.prenomErrone = prenomErrone;
    }

    @Override
    public String getMessage() {
        return "Le prenom est erroné et vaut " + prenomErrone;
    }
}
