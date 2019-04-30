package vue;

import javax.swing.*;

public class ElementFormulaireJComboBox extends ElementFormulaire<JComboBox>{
    public ElementFormulaireJComboBox(String nom, String []valuesSexe ) {
        super(nom);
        setField(new JComboBox(valuesSexe));
    }

    @Override
    public Object getValue() {
        return getField().getSelectedItem();
    }
}
