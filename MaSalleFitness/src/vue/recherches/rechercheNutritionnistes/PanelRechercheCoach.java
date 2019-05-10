package vue.recherches.rechercheNutritionnistes;

import model.Coach;
import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRechercheCoach extends PanelBase<FormulaireRechercheCoach> {
    private ListingNutritionniste listingNutritionniste;
    private FormulaireRechercheCoach formulaireRechercheNutritionniste = new FormulaireRechercheCoach();

    public PanelRechercheCoach(ListingNutritionniste listingNutritionniste) {
        super("Selection d'un coach", "Retour", "Valider");
        addFormulaire(formulaireRechercheNutritionniste);
        this.listingNutritionniste = listingNutritionniste;

        setListenerBouton1(new RetourListener());
        setListenerBouton2(new ValiderListener());
    }
    private class RetourListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listingNutritionniste.retour();
        }
    }
    private class ValiderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Coach coach = getFormulaire().getCoach();
            listingNutritionniste.afficherListingNutri(coach);
        }
    }

    public void rafraichir(){
        formulaireRechercheNutritionniste.rafraichir();
    }
}
