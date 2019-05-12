package model.exceptions;

public class RueException extends IllegalArgumentException {
    private String rueErronee;

    public RueException(String rueErronee) {
        this.rueErronee = rueErronee;
    }

    @Override
    public String getMessage() {
        return "Le nom de la rue est erroné et vaut " + rueErronee;
    }
}
