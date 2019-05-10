package vue.recherches.rechercheNutritionnistes;

import model.Coach;
import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListeNutri extends PanelBase<FormulaireListingNutri> {
    private ListingNutritionniste listingNutritionniste;
    private FormulaireListingNutri listingNutriFormulaire = new FormulaireListingNutri();

    public PanelListeNutri(ListingNutritionniste listingNutritionniste){
        super("<html><h1>Liste des nutritionnistes travaillant avec ce coach</h1></html>","Retour","Afficher");
        addFormulaire(listingNutriFormulaire);
        this.listingNutritionniste = listingNutritionniste;

        setListenerBouton1(new RetourListener());
    }
    private class RetourListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listingNutritionniste.retour();
        }
    }

    public void setCoach(Coach coach){
        listingNutriFormulaire.setCoach(coach);
    }
}
