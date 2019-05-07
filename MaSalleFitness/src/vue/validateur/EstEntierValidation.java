package vue.validateur;

public class EstEntierValidation implements Validation {
    @Override
    public boolean valider(Object o) {
        return  o instanceof Integer;
    }
}
