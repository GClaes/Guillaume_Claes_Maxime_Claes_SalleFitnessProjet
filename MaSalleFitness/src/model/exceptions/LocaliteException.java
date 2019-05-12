package model.exceptions;

public class LocaliteException extends IllegalArgumentException {
    private String localiteErrone;

    public LocaliteException(String localiteErrone) {
        this.localiteErrone = localiteErrone;
    }

    @Override
    public String getMessage() {
        return "La localite est erroné et vaut " + localiteErrone;
    }
}
