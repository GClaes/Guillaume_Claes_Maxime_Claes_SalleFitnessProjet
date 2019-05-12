package model.exceptions;

public class CodePostalException extends IllegalArgumentException {
    private String codePostalErrone;

    public CodePostalException(String codePostalErrone) {
        this.codePostalErrone = codePostalErrone;
    }

    @Override
    public String getMessage() {
        return "Le code postal est erroné et vaut " + codePostalErrone;
    }
}
