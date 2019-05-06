package vue.element;

import vue.validateur.Validation;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class ElementFormulaireJSpinnerDate extends ElementFormulaire<JSpinner> {

    public ElementFormulaireJSpinnerDate(String text, Validation validation) {
        super(text, validation);
        JSpinner date = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        date.setEditor(new JSpinner.DateEditor(date,"dd - MM - yyyy"));
        setField(date);
    }

    @Override
    public Object getValue() {
        return getField().getValue();
    }


}