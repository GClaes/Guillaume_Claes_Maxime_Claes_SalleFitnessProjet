package vue.panel.inscription;

import business.*;
import model.Candidat;
import model.Coach;
import model.Nutritionniste;
import model.Responsable;
import vue.element.ElementFormulaireJComboBox;
import vue.element.ElementFormulaireJSpinnerNb;
import vue.element.ElementFormulaireJTextField;
import vue.validateur.*;

import java.awt.*;
import java.util.ArrayList;

public class PanelFormulaire3 extends PanelFormulaireBase {
    public PanelFormulaire3() {
        setLayout(new GridLayout(5, 2, 50, 75));

        //AMELIROER VALIDATEURS
        setComposantes("nbHeures", new ElementFormulaireJSpinnerNb("Nombre d'heures de coaching désiré", new NbValidation(1,'>')));
        setComposantes("maladie", new ElementFormulaireJTextField("Maladies chroniques éventuelles", 255, new VideValidation()));
        setComposantes("coach", new ElementFormulaireJComboBox("Coach", afficherListeCoachs(),new PasVideValidation()));
        setComposantes("nutri", new ElementFormulaireJComboBox("Coach",afficherListeNutritionnistes(),new PasVideValidation()));
        setComposantes("responsable", new ElementFormulaireJComboBox("Reponsable",afficherListeResponsables(),new PasVideValidation()));



        initList();
    }

    public int getNbHeures(){
        return (int)getComposantes().get("nbHeures").getValue();
    }
    public String getMaladies(){
        return (String)getComposantes().get("maladie").getValue();
    }
    public Coach getCoach(){
        return (Coach)getComposantes().get("coach").getValue();
    }
    public Nutritionniste getNutri(){
        return (Nutritionniste)getComposantes().get("nutri").getValue();
    }
    public Responsable getResponsable(){
        return(Responsable)getComposantes().get("responsable").getValue();
    }

    public String[] afficherListeCoachs(){
        CoachService coachService = new CoachServiceImp();
        ArrayList<Coach>listeCoachs = coachService.listingCoachs();
        String[]valuesCoach = new String[listeCoachs.size()];
        int position = 0;
        for(Coach coach : listeCoachs){
            int nbHeures = 0;
            for(Candidat candidat : coach.getCandidats()){
                nbHeures+= candidat.getNbHeuresCoaching();
            }
            valuesCoach[position] = coach.getPrenom()+" "+coach.getNom()+" "+nbHeures+"/20 heures dispos";
            position++;
        }
        return valuesCoach;
    }

    public String[] afficherListeNutritionnistes(){
        NutritionnisteService nutritionnisteService = new NutritionnisteServiceImp();
        ArrayList<Nutritionniste>listeNutritionnistes = nutritionnisteService.listingNutritionnistes();
        String[]valuesNutri = new String[listeNutritionnistes.size()];
        int position = 0;
        for(Nutritionniste nutri : listeNutritionnistes){
            valuesNutri[position] = nutri.getPrenom()+" "+nutri.getNom();
            position++;
        }
        return valuesNutri;
    }
    public String[] afficherListeResponsables(){
        ResponsableService responsableService = new ResponsableServiceImp();
        ArrayList<Responsable>listeResponsables = responsableService.listingResponsables();
        String[]valuesResp = new String[listeResponsables.size()];
        int position = 0;
        for(Responsable responsable: listeResponsables){
            valuesResp[position] = responsable.getPrenom()+" "+responsable.getNom();
            position++;
        }
        return valuesResp;
    }
}
