package model.exceptions;

public class NomException extends IllegalArgumentException {
    private String nomErrone;

    public NomException(String nomErrone) {
        this.nomErrone = nomErrone;
    }

    @Override
    public String getMessage() {
        return "Le nom est erroné et vaut " + nomErrone;
    }
}
