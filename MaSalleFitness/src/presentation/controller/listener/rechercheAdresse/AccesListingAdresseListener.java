package presentation.controller.listener.rechercheAdresse;

import model.Responsable;
import presentation.vue.recherches.rechercheAdresse.FormulaireRechercheDates;
import presentation.vue.recherches.rechercheAdresse.ListingAdresse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AccesListingAdresseListener implements ActionListener {
    private ListingAdresse listingAdresse;
    private FormulaireRechercheDates formulaire;

    public AccesListingAdresseListener(ListingAdresse listingAdresse, FormulaireRechercheDates formulaire) {
        this.listingAdresse = listingAdresse;
        this.formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Responsable responsable = formulaire.getResponsable();
        Date dateDebut = formulaire.getDateDebut();
        Date dateFin = formulaire.getDateFin();
        listingAdresse.afficherListingAdresse(responsable, dateDebut, dateFin);
    }
}
