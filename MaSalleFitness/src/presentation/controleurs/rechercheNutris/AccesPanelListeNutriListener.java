package presentation.controleurs.rechercheNutris;

import model.Coach;
import presentation.vue.recherches.rechercheNutritionnistes.FormulaireRechercheCoach;
import presentation.vue.recherches.rechercheNutritionnistes.RechercheNutri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelListeNutriListener implements ActionListener {
    private RechercheNutri rechercheNutri;
    private FormulaireRechercheCoach formulaire;

    public AccesPanelListeNutriListener(RechercheNutri rechercheNutri, FormulaireRechercheCoach formulaire) {
        this.rechercheNutri = rechercheNutri;
        this.formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Coach coach = formulaire.getCoach();
        rechercheNutri.afficherListingNutri(coach);
    }
}
