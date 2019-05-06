package vue.panel.inscription;

import model.Coach;
import vue.element.ElementFormulaire;
import vue.element.ElementFormulaireJComboBox;
import vue.element.ElementFormulaireJSpinnerNb;
import vue.element.ElementFormulaireJTextField;
import vue.validateur.*;

import java.awt.*;
import java.util.Map;

public class PanelFormulaire3 extends PanelFormulaireBase {
    public PanelFormulaire3() {
        setLayout(new GridLayout(5, 2, 50, 75));

        //AMELIROER VALIDATEURS
        setComposantes("nbHeures", new ElementFormulaireJSpinnerNb("Nombre d'heures de coaching désiré", new NbValidation(1,'>')));
        setComposantes("maladie", new ElementFormulaireJTextField("Maladies chroniques éventuelles", 255, new VideValidation()));
        String[]valuesCoach = {"Coach1 /20 heures restante(s)", "Coach2", "Coach3"};
        setComposantes("coach", new ElementFormulaireJComboBox("Coach",valuesCoach,new PasVideValidation()));
        String[]valuesNutritionniste = {"Nutri1", "Nutri2", "Nutri3"};
        setComposantes("nutri", new ElementFormulaireJComboBox("Coach",valuesNutritionniste,new PasVideValidation()));
        String[]valuesResponsable = {"Responsable 1", "Responsable 2", "Responsable 3"};
        setComposantes("responsable", new ElementFormulaireJComboBox("Reponsable",valuesResponsable,new PasVideValidation()));


        initList();
    }

    public int getNbHeures(){
        return (int)getComposantes().get("nbHeures").getValue();
    }
    public String getMaladies(){
        return (String)getComposantes().get("maladie").getValue();
    }
    public int getCoach(){
        //A MODIF
        return (int)getComposantes().get("coach").getValue();
    }
    public int getNutri(){
        //A MODIF
        return (int)getComposantes().get("nutri").getValue();
    }
    public int getResponsable(){
        //A MODIF
        return(int)getComposantes().get("responsable").getValue();
    }
}
