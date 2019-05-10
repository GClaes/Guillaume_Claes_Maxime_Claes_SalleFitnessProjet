package vue.recherche.rechercheCandidat;

import vue.inscription.PanelBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRecherche extends PanelBase<FormulaireRecherche> {
    private Recherche recherche;
    private FormulaireRecherche formulaireRecherche = new FormulaireRecherche();
    public PanelRecherche(Recherche recherche){
        super("<html><h1>Recherche d'un candidat","Annuler","Rechercher");
        addFormulaire(formulaireRecherche);
        this.recherche = recherche;
        setListenerBouton1(new RetourListener());
        setListenerBouton2(new RechercherListener());

    }
    private class RechercherListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().validation()) {
                recherche.recherche(getFormulaire().getId());
            }
        }
    }
    private class RetourListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            recherche.retour();
        }
    }
    public void rafraichir(){
        formulaireRecherche.rafraichir();
    }
}
