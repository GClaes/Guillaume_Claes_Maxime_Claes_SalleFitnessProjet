package vue.recherche;

import model.Candidat;
import vue.inscription.PanelBase;
import vue.recherche.rechercheCandidat.Recherche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCandidatInfo extends PanelBase<CandidatFormulaire> {
    private Recherche recherche;
    private CandidatFormulaire candidatFormulaire = new CandidatFormulaire();
    private Candidat candidat;

    public PanelCandidatInfo(Recherche recherche) {
        super("<html><h1>Fiche du candidat recherché</h1></html>", "Supprimer","Modifier");
        this.addFormulaire(candidatFormulaire);
        this.recherche = recherche;
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

    public void setCandidat(Candidat candidat){
        this.candidat = candidat;
        candidatFormulaire.setCandidat(candidat);
    }
}
