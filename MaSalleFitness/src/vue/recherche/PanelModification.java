package vue.recherche;

import business.CandidatService;
import business.CandidatServiceImp;
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
            FormulaireModification formulaire = getFormulaire();
            if(formulaire.validation()){
                Candidat candidat = new Candidat(
                        formulaire.getNbHeures(),
                        formulaire.getNom(),
                        formulaire.getPrenom(),
                        formulaire.getDateNaissance(),
                        formulaire.getSexe(),
                        formulaire.getCoach(),
                        formulaire.getResponsable(),
                        formulaire.getNutri(),
                        formulaire.getAdresse());
                if(formulaire.getValiderTest()){
                    candidat.setDateTestValide(formulaire.getDateTestValide());
                }
                if(!formulaire.getNumero().equals("")){
                    candidat.setNumeroGSM(formulaire.getNumero());
                }
                if(!formulaire.getMaladies().equals("")){
                    candidat.setMaladiesChroniques(formulaire.getMaladies());
                }
                CandidatService candidatService = new CandidatServiceImp();
                //APPELR MODIF
            }
        }
    }
}
