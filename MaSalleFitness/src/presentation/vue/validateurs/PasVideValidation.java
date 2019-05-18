package presentation.vue.validateurs;

public class PasVideValidation implements Validation {
    public PasVideValidation() {

    }

    @Override
    public boolean valider(Object o) {
        return o != null && !o.toString().trim().equals("");
    }
}
