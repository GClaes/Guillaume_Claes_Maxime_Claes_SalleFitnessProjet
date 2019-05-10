package vue.recherche;

import business.CoachService;
import business.imp.CoachServiceImp;
import model.Candidat;
import vue.inscription.PanelBase;
import vue.recherche.rechercheCandidat.Recherche;

import javax.swing.*;
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
            CoachService coachService = CoachServiceImp.getInstance();
            int nbHeuresCoachDispo = 20 - coachService.nbHeuresCoachingUtilisees(getFormulaire().getCoach().getMatricule());
            if(formulaire.validation()){
                if(nbHeuresCoachDispo >= getFormulaire().getNbHeures()) {
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
                    candidat.setNumInscrit(formulaire.getNumInscription());
                    candidat.setDateInscription(formulaire.getDateInscription());
                    candidat.setDateTestValide(formulaire.getDateTestValide());

                    if (!formulaire.getNumTel().equals("")) {
                        candidat.setNumeroGSM(formulaire.getNumTel());
                    }
                    if (!formulaire.getMaladies().equals("")) {
                        candidat.setMaladiesChroniques(formulaire.getMaladies());
                    }
                    recherche.modifierCandidat(candidat);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Le coach choisi n'a plus assez d'heures. \n " +
                            "Veuillez prendre moins d'heures de coaching.");

                }
            }
        }
    }
}
