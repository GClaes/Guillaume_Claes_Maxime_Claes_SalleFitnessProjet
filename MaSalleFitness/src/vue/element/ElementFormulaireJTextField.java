package vue;

import javax.swing.*;

public class ElementFormulaireJTextField extends ElementFormulaire<JTextField> {

    public ElementFormulaireJTextField(String nom, int tailleField) {
        super(nom);
        setField(new JTextField(tailleField));
    }

    @Override
    public Object getValue() {
        return getField().getText();
    }


}
