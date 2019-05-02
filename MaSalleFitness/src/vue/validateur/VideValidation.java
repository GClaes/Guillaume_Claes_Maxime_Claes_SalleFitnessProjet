package vue.validateur;

public class VideValidation implements Validation {
    public VideValidation() {
    }

    @Override
    public boolean valider(Object o) {
        return o==null || o.equals("");
    }
}
