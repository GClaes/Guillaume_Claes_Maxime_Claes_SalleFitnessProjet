package dataAccess.exceptions;

public class ListingException extends IllegalArgumentException {
    public ListingException(Exception e) {
        super(e);
    }
}
