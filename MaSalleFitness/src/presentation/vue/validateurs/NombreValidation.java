package presentation.vue.validateurs;

public class NombreValidation implements Validation {
    private int nb;
    private Sens sens;

    public enum Sens{
        PLUS_GRAND,PLUS_PETIT;
    }

    public NombreValidation(int nb, Sens sens) {
        this.nb = nb;
        this.sens = sens;
    }

    @Override
    public boolean valider(Object o) {
        if(sens == Sens.PLUS_GRAND) {
            return Integer.parseInt(o.toString()) >= nb;
        }
        else{
            return Integer.parseInt(o.toString()) <= nb;
        }
    }
}
