package vue.recherches.rechercheNutritionnistes;

import model.Coach;
import vue.inscription.PanelBase;
import vue.listing.ListingFormulaire;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListeNutri extends PanelBase<ListingNutriFormulaire> {
    private ListingNutritionniste listingNutritionniste;
    private ListingNutriFormulaire listingNutriFormulaire = new ListingNutriFormulaire();

    public PanelListeNutri(ListingNutritionniste listingNutritionniste){
        super("Liste des nutritionnistes travaillant avec ce coach","Retour","Afficher");
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
