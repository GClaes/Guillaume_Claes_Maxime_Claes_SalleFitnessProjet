package presentation.vue.elements;

import presentation.vue.validateurs.Validation;
import javax.swing.*;

public class ElementFormulaireJTextField extends ElementFormulaire<JTextField> {

    public ElementFormulaireJTextField(String label, int tailleField) {
        super(label, null);
        setField(new JTextField(tailleField));
    }
    public ElementFormulaireJTextField(String label, int tailleField, Validation validation) {
        super(label, validation);
        setField(new JTextField(tailleField));
    }
    public ElementFormulaireJTextField(String label, int tailleField, Validation validation, String valeur){
        super(label, validation);
        setField(new JTextField(valeur, tailleField));
    }
    public ElementFormulaireJTextField(String label, int tailleField, String valeur){
        super(label, null);
        setField(new JTextField(valeur, tailleField));
    }

    @Override
    public Object getValue() {
        return getField().getText();
    }
}
