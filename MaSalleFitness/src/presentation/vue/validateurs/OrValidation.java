package presentation.vue.validateurs;

public class OrValidation extends ValidationComposee {
    public OrValidation(Validation v1, Validation v2) {
        super(v1, v2);
    }

    @Override
    public boolean valider(Object o) {
        for(Validation v:getValidations()){
            if(v.valider(o)){
                return true;
            }
        }
        return false;
    }
}
