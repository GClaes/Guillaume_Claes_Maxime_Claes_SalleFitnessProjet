package presentation.controleurs.inscription;

import business.CoachService;
import business.impl.CoachServiceImpl;
import presentation.vue.inscription.Inscription;
import presentation.vue.inscription.formulaire.FormulaireCoaching;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvoyerListener implements ActionListener {
    private FormulaireCoaching formulaire;
    private Inscription inscription;
    private CoachService coachService = CoachServiceImpl.getInstance();

    public EnvoyerListener(FormulaireCoaching formulaire, Inscription inscription) {
        this.formulaire = formulaire;
        this.inscription = inscription;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nbHeuresCoachDispo = 20 - coachService.nbHeuresCoachingUtilisees(formulaire.getCoach().getMatricule());
        if(formulaire.validation()){
            if(nbHeuresCoachDispo >= formulaire.getNbHeures()) {
                inscription.envoyerInscription(
                        formulaire.getNbHeures(),
                        formulaire.getMaladies(),
                        formulaire.getResponsable(),
                        formulaire.getCoach(),
                        formulaire.getNutri());
            }
            else{
                JOptionPane.showMessageDialog(null,"Le coach choisi n'a plus assez d'heures. \n " +
                        "Veuillez choisir un autre coach, ou prendre moins d'heures de coaching.");
            }
        }
    }
}
