package model.exceptions;

public class CodeHachException extends IllegalArgumentException {
    private String codeHachErrone;

    public CodeHachException(String codeHachErrone) {
        this.codeHachErrone = codeHachErrone;
    }

    @Override
    public String getMessage() {
        return "Le code hach de l adresse est errone et vaut " + codeHachErrone;
    }
}
