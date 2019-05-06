package model.exceptions;

public class NumeroGSMException extends IllegalArgumentException {
    private String numeroGSMErrone;

    public NumeroGSMException(String numeroGSMErrone) {
        this.numeroGSMErrone = numeroGSMErrone;
    }

    @Override
    public String getMessage() {
        return "Le numero de gsm est errone et vaut " + numeroGSMErrone;
    }
}
