package presentation.vue.validateurs;

public class VideValidation implements Validation {
    public VideValidation() {
    }

    @Override
    public boolean valider(Object o) {
        return o==null || o.equals("");
    }
}
