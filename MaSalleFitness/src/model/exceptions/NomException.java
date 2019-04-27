package model.exceptions;

public class NomException extends Exception {
    private String nomErrone;

    public NomException(String nomErrone) {
        this.nomErrone = nomErrone;
    }

    @Override
    public String getMessage() {
        return "Le nom est errone et vaut " + nomErrone;
    }
}
