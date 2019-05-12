package presentation.controleurs.recherche;

import business.CoachService;
import business.impl.CoachServiceImpl;
import model.Candidat;
import presentation.vue.recherches.FormulaireModification;
import presentation.vue.recherches.rechercheCandidat.Recherche;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifierListener implements ActionListener {
    private FormulaireModification formulaire;
    private Recherche recherche;

    public ModifierListener(FormulaireModification formulaire, Recherche recherche) {
        this.formulaire = formulaire;
        this.recherche = recherche;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CoachService coachService = CoachServiceImpl.getInstance();
        int nbHeuresCoachDispo = 20 - coachService.nbHeuresCoachingUtilisees(formulaire.getCoach().getMatricule());
        if(formulaire.validation()){
            if(nbHeuresCoachDispo >= formulaire.getNbHeures()) {
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
