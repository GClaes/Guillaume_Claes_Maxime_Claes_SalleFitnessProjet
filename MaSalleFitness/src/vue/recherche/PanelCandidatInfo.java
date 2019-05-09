package vue.recherche;

import model.Candidat;
import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCandidatInfo extends PanelBase<CandidatFormulaire> {
    private Recherche recherche;
    private Candidat candidat;

    public PanelCandidatInfo(Recherche recherche, Candidat candidat) {
        super("<html><h1>Fiche du candidat recherché</h1></html>", "Supprimer","Modifier",new CandidatFormulaire(candidat));
        this.recherche = recherche;
        this.candidat = candidat;

        setListenerBouton1(new SupprimerListener());
        setListenerBouton2(new ModifierListener());
    }
    private class SupprimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            recherche.supprimer(candidat);
        }
    }

    private class ModifierListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            recherche.modifier(candidat);
        }
    }
}
