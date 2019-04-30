package model.exceptions;

public class SexeException extends Exception {
    private char sexeErrone;

    public SexeException(char sexeErrone) {
        this.sexeErrone = sexeErrone;
    }

    @Override
    public String getMessage() {
        return "Le sexe est errone et vaut " + sexeErrone;
    }
}