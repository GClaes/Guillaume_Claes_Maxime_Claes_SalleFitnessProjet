package vue.validateur;

public class nbValidation implements Validation {
    private int nb;

    public nbValidation(int nb) {
        this.nb = nb;
    }

    @Override
    public boolean valider(Object o) {
        return (int)o >= nb;
    }
}
