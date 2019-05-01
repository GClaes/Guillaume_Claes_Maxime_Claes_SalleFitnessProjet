package model.exceptions;

public class RueException extends Exception {
    private String rueErronee;

    public RueException(String rueErronee) {
        this.rueErronee = rueErronee;
    }

    @Override
    public String getMessage() {
        return "Le nom de la rue est errone et vaut " + rueErronee;
    }
}
