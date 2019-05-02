package vue.validateur;

public class NbValidation implements Validation {
    private int nb;

    public NbValidation(int nb) {
        this.nb = nb;
    }

    @Override
    public boolean valider(Object o) {
        return (int)o >= nb;
    }
}
