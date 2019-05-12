package presentation.vue.validateurs;

import utilitaires.DateUtilitaire;

import java.util.Date;

public class AgeValidation implements Validation {
    @Override
    public boolean valider(Object o) {
        return DateUtilitaire.age((Date)o)>= 16;
    }
}
