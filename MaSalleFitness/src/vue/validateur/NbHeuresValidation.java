package vue.validateur;

public class NbHeuresValidation implements Validation {
    private int nb1;
    private char sens;
    private int nb2;

    public NbHeuresValidation(int nb1, char sens, int nb2) {
        this.nb1 = nb1;
        this.sens = sens;
        this.nb2 = nb2;
    }

    @Override
    public boolean valider(Object o) {
        if(sens == '>'){
            return nb1 >= nb2;
        }
        else{
            return nb1 <= nb2;
        }
    }
}
