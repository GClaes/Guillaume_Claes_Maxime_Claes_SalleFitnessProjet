package vue.validateur;

import java.util.Date;

public class DateValidation implements Validation {
    private Date date;
    public DateValidation(Date date){
        this.date = date;
    }
    @Override
    public boolean valider(Object o) {
        return (((Date)o).compareTo(date) >= 0);
    }
}
