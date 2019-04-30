package vue.validateur;

public class AndValidation extends ValidationComposee {

    public AndValidation(Validation v1, Validation v2) {
        super(v1, v2);
    }

    @Override
    public boolean valider(Object o) {
        for(Validation v: getValidations()){
            if(!v.valider(o)) {
                return false;
            }
        }
        return true;
    }
}
