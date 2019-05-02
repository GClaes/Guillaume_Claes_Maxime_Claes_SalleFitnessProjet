package model.exceptions;

import java.util.Date;

public class DateNaissanceException extends IllegalArgumentException {
    private Date dateNaissanceErronee;

    public DateNaissanceException(Date dateNaissanceErronee) {
        this.dateNaissanceErronee = dateNaissanceErronee;
    }

    @Override
    public String getMessage() {
        return "La date de naissance est errone et vaut " + dateNaissanceErronee;
    }
}
