package vue.inscription.formulaire;

import business.*;
import business.impl.CoachServiceImpl;
import business.impl.NutritionnisteServiceImpl;
import business.impl.ResponsableServiceImpl;
import model.Coach;
import model.Nutritionniste;
import model.Responsable;
import vue.element.*;
import vue.validateur.*;

import java.awt.*;
import java.util.ArrayList;

public class PanelFormulaire3 extends PanelFormulaireBase {
    private ArrayList<Coach>listeCoachs;
    private ArrayList<Nutritionniste>listeNutritionnistes;
    private ArrayList<Responsable>listeResponsables;
    private CoachService coachService;
    private NutritionnisteService nutritionnisteService;
    private ResponsableService responsableService;
    public PanelFormulaire3() {
        setLayout(new GridLayout(5, 2, 50, 75));
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
            int nbHeuresCoach = coachService.nbHeuresCoachingUtilisees(coach.getMatricule());
            valuesCoach[position] = coach.getPrenom() + " " + coach.getNom() + " " + (20 - nbHeuresCoach) + "/20 heure(s) dispo(s)";
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

    public void rafraichir(){
        coachService =  CoachServiceImpl.getInstance();
        nutritionnisteService = NutritionnisteServiceImpl.getInstance();
        responsableService = ResponsableServiceImpl.getInstance();
        listeCoachs = coachService.listingCoachs();
        listeNutritionnistes = nutritionnisteService.listingNutritionnistes();
        listeResponsables = responsableService.listingResponsables();

        removeAll();
        setComposantes("nbHeures", new ElementFormulaireJSpinnerNb("Nombre d'heures de coaching désiré", new NbValidation(1,'>')));
        setComposantes("maladie", new ElementFormulaireJTextField("Maladies chroniques éventuelles", 255));
        setComposantes("coach", new ElementFormulaireJComboBox("Coach", afficherListeCoachs()));
        setComposantes("nutri", new ElementFormulaireJComboBox("Nutritionniste",afficherListeNutritionnistes()));
        setComposantes("responsable", new ElementFormulaireJComboBox("Reponsable",afficherListeResponsables()));

        initList();
    }
}
