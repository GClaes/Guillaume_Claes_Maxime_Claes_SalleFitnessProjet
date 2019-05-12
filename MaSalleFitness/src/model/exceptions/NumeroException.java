package model.exceptions;

public class NumeroException extends IllegalArgumentException {
    private String numeroErrone;

    public NumeroException(String numeroErrone) {
        this.numeroErrone = numeroErrone;
    }

    @Override
    public String getMessage() {
        return "Le numero de residence est erroné et vaut " + numeroErrone;
    }
}
