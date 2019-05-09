package vue.element;

import vue.validateur.Validation;

import javax.swing.*;

public class ElementFormulaireJTextField extends ElementFormulaire<JTextField> {

    public ElementFormulaireJTextField(String nom, int tailleField, Validation validation) {
        super(nom, validation);
        setField(new JTextField(tailleField));
    }
    public ElementFormulaireJTextField(String nom, int tailleField, Validation validation, String valeur){
        super(nom, validation);
        setField(new JTextField(valeur, tailleField));
    }

    @Override
    public Object getValue() {
        return getField().getText().toLowerCase();
    }
}
