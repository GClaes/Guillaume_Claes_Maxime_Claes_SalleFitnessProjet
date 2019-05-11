package presentation.controller.listener.rechercheNutris;

import model.Coach;
import presentation.vue.recherches.rechercheNutritionnistes.FormulaireRechercheCoach;
import presentation.vue.recherches.rechercheNutritionnistes.ListingNutritionniste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelListeNutriListener implements ActionListener {
    private ListingNutritionniste listingNutritionniste;
    private FormulaireRechercheCoach formulaire;

    public AccesPanelListeNutriListener(ListingNutritionniste listingNutritionniste, FormulaireRechercheCoach formulaire) {
        this.listingNutritionniste = listingNutritionniste;
        this.formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Coach coach = formulaire.getCoach();
        listingNutritionniste.afficherListingNutri(coach);
    }
}
