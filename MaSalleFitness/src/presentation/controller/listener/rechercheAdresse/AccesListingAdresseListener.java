package presentation.controller.listener.rechercheAdresse;

import model.Responsable;
import presentation.vue.recherches.rechercheAdresse.FormulaireRechercheDates;
import presentation.vue.recherches.rechercheAdresse.RechercheAdresse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AccesListingAdresseListener implements ActionListener {
    private RechercheAdresse rechercheAdresse;
    private FormulaireRechercheDates formulaire;

    public AccesListingAdresseListener(RechercheAdresse rechercheAdresse, FormulaireRechercheDates formulaire) {
        this.rechercheAdresse = rechercheAdresse;
        this.formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Responsable responsable = formulaire.getResponsable();
        Date dateDebut = formulaire.getDateDebut();
        Date dateFin = formulaire.getDateFin();
        rechercheAdresse.afficherListingAdresse(responsable, dateDebut, dateFin);
    }
}
