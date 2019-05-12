package model.exceptions;

public class SexeException extends IllegalArgumentException {
    private char sexeErrone;

    public SexeException(char sexeErrone) {
        this.sexeErrone = sexeErrone;
    }

    @Override
    public String getMessage() {
        return "Le sexe est erroné et vaut " + sexeErrone;
    }
}
