package vue.recherches.rechercheCoachs;

import model.Responsable;
import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListeCoachs extends PanelBase<FormulaireListingCoach> {
    private ListingCoach listingCoach;
    private FormulaireListingCoach panelListingCoachFormulaire = new FormulaireListingCoach();

    public PanelListeCoachs(ListingCoach listingCoach) {
        super("<html><h1>Liste des coachs des candidats inscrits par ce responsable</h1></html>","Retour","");
        addFormulaire(panelListingCoachFormulaire);
        this.listingCoach = listingCoach;

        setListenerBouton1(new RetourListener());
    }

    private class RetourListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            listingCoach.retour();
        }
    }
    public void setResponsable(Responsable responsable){
        panelListingCoachFormulaire.setResponsable(responsable);
    }
}
