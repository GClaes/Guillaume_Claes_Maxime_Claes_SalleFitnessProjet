package presentation.controleurs.rechercheCoachs;

import model.Responsable;
import presentation.vue.recherches.rechercheCoachs.FormulaireRechercheResponsable;
import presentation.vue.recherches.rechercheCoachs.RechercheCoach;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelListeCoachsListener implements ActionListener {
    private RechercheCoach rechercheCoach;
    private FormulaireRechercheResponsable formulaire;

    public AccesPanelListeCoachsListener(RechercheCoach rechercheCoach, FormulaireRechercheResponsable formulaire) {
        this.rechercheCoach = rechercheCoach;
        this.formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Responsable responsable = formulaire.getResponsable();
        rechercheCoach.afficherListingCoach(responsable);

    }
}
