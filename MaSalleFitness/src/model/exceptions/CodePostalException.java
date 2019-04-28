package model.exceptions;

public class CodePostalException extends Exception {
    private String codePostalErrone;

    public CodePostalException(String codePostalErrone) {
        this.codePostalErrone = codePostalErrone;
    }

    @Override
    public String getMessage() {
        return "Le code postal est errone et vaut " + codePostalErrone;
    }
}
