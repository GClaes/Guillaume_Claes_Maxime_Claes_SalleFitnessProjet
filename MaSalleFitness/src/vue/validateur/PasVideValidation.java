package vue.validateur;

public class PasVideValidation implements Validation {
    public PasVideValidation() {

    }

    @Override
    public boolean valider(Object o) {
        return o != null && (String)o != " ";
    }
}
