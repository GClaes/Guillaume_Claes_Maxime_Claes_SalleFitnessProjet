package vue.validateur;

public class NbValidation implements Validation {
    private int nb;
    private char sens;

    public NbValidation(int nb, char sens) {
        this.nb = nb;
        this.sens = sens;
    }

    @Override
    public boolean valider(Object o) {
        if(sens =='>')
        return (int)o >= nb;
        else{
            return (int)o <= nb;
        }
    }
}
