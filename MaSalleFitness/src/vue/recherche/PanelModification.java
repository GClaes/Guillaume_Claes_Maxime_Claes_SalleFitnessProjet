package vue.recherche;

import model.Candidat;
import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModification extends PanelBase<FormulaireModification> {
    private Recherche recherche;
    public PanelModification(Recherche recherche, Candidat candidat) {
        super("<html><h1>Modification d'un candidat</h1></html>","Annuler", "Valider", new FormulaireModification(candidat));
        this.recherche = recherche;

        setListenerBouton1(new AnnulerListener());
        setListenerBouton2(new ModifierListener());
    }

    private class AnnulerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            recherche.retour();
        }
    }
    private class ModifierListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //MODIFIER CANDIDAT
        }
    }
}
