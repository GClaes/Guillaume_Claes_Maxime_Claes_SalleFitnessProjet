package vue.recherches.rechercheAdresse;

import model.Responsable;
import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PanelRechercheCandidat extends PanelBase<FormulaireRechercheDates> {
    private ListingAdresse listingAdresse;
    private FormulaireRechercheDates formulaireRechercheDates = new FormulaireRechercheDates();
    public PanelRechercheCandidat(ListingAdresse listingAdresse){
        super("<html><h1>Selection d'un responsable et des dates</h1></html>", "Retour", "Valider");
        addFormulaire(formulaireRechercheDates);
        this.listingAdresse = listingAdresse;

        setListenerBouton1(new RetourListener());
        setListenerBouton2(new ValiderListener());
    }
    private class RetourListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            listingAdresse.retour();
        }
    }
    private class ValiderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Responsable responsable = getFormulaire().getResponsable();
            Date dateDebut = getFormulaire().getDateDebut();
            Date dateFin = getFormulaire().getDateFin();
            listingAdresse.afficherListingAdresse(responsable, dateDebut, dateFin);
        }
    }
    public void rafraichir(){
        formulaireRechercheDates.rafraichir();
    }
}
