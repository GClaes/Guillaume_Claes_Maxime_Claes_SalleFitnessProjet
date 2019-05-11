package presentation.vue.validateur;

import java.util.ArrayList;

public abstract class ValidationComposee implements Validation {

    private ArrayList<Validation> validations = new ArrayList<>();

    public ValidationComposee(Validation v1, Validation v2) {
        validations.add(v1);
        validations.add(v2);
    }

    @Override
    public abstract boolean valider(Object o);

    public ArrayList<Validation> getValidations() {
        return validations;
    }
}
