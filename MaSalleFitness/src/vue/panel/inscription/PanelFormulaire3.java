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
    private ArrayList<Coach>listeCoachs;
    private ArrayList<Nutritionniste>listeNutritionnistes;
    private ArrayList<Responsable>listeResponsables;
    public PanelFormulaire3() {
        CoachService coachService = new CoachServiceImp();
        listeCoachs = coachService.listingCoachs();
        NutritionnisteService nutritionnisteService = new NutritionnisteServiceImp();
        listeNutritionnistes = nutritionnisteService.listingNutritionnistes();
        ResponsableService responsableService = new ResponsableServiceImp();
        listeResponsables = responsableService.listingResponsables();


        setLayout(new GridLayout(5, 2, 50, 75));

        //AMELIROER VALIDATEURS
        setComposantes("nbHeures", new ElementFormulaireJSpinnerNb("Nombre d'heures de coaching désiré", new NbValidation(1,'>')));
        setComposantes("maladie", new ElementFormulaireJTextField("Maladies chroniques éventuelles", 255, new VideValidation()));

        setComposantes("coach", new ElementFormulaireJComboBox("Coach", afficherListeCoachs(),new PasVideValidation()));
        setComposantes("nutri", new ElementFormulaireJComboBox("Nutritionniste",afficherListeNutritionnistes(),new PasVideValidation()));
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
        int indice = (int)getComposantes().get("coach").getValue();
        return listeCoachs.get(indice);
    }
    public Nutritionniste getNutri(){
        int indice = (int)getComposantes().get("nutri").getValue();
        return listeNutritionnistes.get(indice);
    }
    public Responsable getResponsable(){
        int indice = (int)getComposantes().get("responsable").getValue();
        return listeResponsables.get(indice);
    }

    public String[] afficherListeCoachs(){
        String[]valuesCoach = new String[listeCoachs.size()];
        int position = 0;
        for(Coach coach : listeCoachs){
            int nbHeures = 0;
            for(Candidat candidat : coach.getCandidats()){
                nbHeures+= candidat.getNbHeuresCoaching();
            }
            valuesCoach[position] = coach.getPrenom()+" "+coach.getNom()+" "+(20-nbHeures)+"/20 heure(s) dispo(s)";
            position++;
        }
        return valuesCoach;
    }

    public String[] afficherListeNutritionnistes(){
        String[]valuesNutri = new String[listeNutritionnistes.size()];
        int position = 0;
        for(Nutritionniste nutri : listeNutritionnistes){
            valuesNutri[position] = nutri.getPrenom()+" "+nutri.getNom();
            position++;
        }
        return valuesNutri;
    }
    public String[] afficherListeResponsables(){
        String[]valuesResp = new String[listeResponsables.size()];
        int position = 0;
        for(Responsable responsable: listeResponsables){
            valuesResp[position] = responsable.getPrenom()+" "+responsable.getNom();
            position++;
        }
        return valuesResp;
    }
}
