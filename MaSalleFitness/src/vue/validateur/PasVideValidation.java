package vue.validateur;

public class PasVide implements Validation {
    public PasVide() {

    }

    @Override
    public boolean valider(Object o) {
        return o != null && (String)o != " ";
    }
}
