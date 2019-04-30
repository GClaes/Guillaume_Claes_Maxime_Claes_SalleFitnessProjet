package model.exceptions;

public class LocaliteException extends Exception {
    private String localiteErrone;

    public LocaliteException(String localiteErrone) {
        this.localiteErrone = localiteErrone;
    }

    @Override
    public String getMessage() {
        return "La localite est errone et vaut " + localiteErrone;
    }
}
