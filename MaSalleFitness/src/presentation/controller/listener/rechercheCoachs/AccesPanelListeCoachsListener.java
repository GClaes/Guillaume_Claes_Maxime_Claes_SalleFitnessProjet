package presentation.controller.listener.rechercheCoachs;

import model.Responsable;
import presentation.vue.recherches.rechercheCoachs.FormulaireRechercheResponsable;
import presentation.vue.recherches.rechercheCoachs.ListingCoach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelListeCoachsListener implements ActionListener {
    private ListingCoach listingCoach;
    private FormulaireRechercheResponsable formulaire;

    public AccesPanelListeCoachsListener(ListingCoach listingCoach, FormulaireRechercheResponsable formulaire) {
        this.listingCoach = listingCoach;
        this.formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Responsable responsable = formulaire.getResponsable();
        listingCoach.afficherListingCoach(responsable);

    }
}
