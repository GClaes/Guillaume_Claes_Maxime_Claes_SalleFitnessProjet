package vue.recherches.rechercheCoachs;

import model.Responsable;
import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelRechercheResponsable extends PanelBase<FormulaireRechercheResponsable> {
    private ListingCoach listingCoach;
    private FormulaireRechercheResponsable formulaireRechercheResponsable = new FormulaireRechercheResponsable();

    public PanelRechercheResponsable(ListingCoach listingCoach) {
        super("Selection d'un responsable", "Retour", "Valider");
        addFormulaire(formulaireRechercheResponsable);
        this.listingCoach = listingCoach;

        setListenerBouton1(new RetourListener());
        setListenerBouton2(new ValiderListener());
    }
    private class RetourListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            listingCoach.retour();
        }
    }
    private class ValiderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Responsable responsable = getFormulaire().getResponsable();
            listingCoach.afficherListingCoach(responsable);
        }
    }
    public void rafraichir(){
        formulaireRechercheResponsable.rafraichir();
    }
}
