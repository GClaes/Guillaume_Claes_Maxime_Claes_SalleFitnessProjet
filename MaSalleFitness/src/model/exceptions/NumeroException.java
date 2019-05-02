package model.exceptions;

public class NumeroException extends Exception {
    private String numeroErrone;

    public NumeroException(String numeroErrone) {
        this.numeroErrone = numeroErrone;
    }

    @Override
    public String getMessage() {
        return "Le numero de residence est errone et vaut " + numeroErrone;
    }
}
