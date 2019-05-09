package vue.inscription;

import business.CoachService;
import business.CoachServiceImp;
import vue.inscription.formulaire.PanelFormulaire3;
import vue.listener.RetourMenuListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCoaching extends PanelBase<PanelFormulaire3> {
    private Inscription inscription;
    private CoachService coachService = new CoachServiceImp();

    public PanelCoaching(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [3/3]</h1></html>", "Annuler","Envoyer",new PanelFormulaire3());
        this.inscription = inscription;
        setListenerBouton1(new RetourMenuListener(inscription));
        setListenerBouton2(new EnvoyerListener());
    }

    public class EnvoyerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int nbHeuresCoachDispo = 20 - coachService.nbHeuresCoachingUtilisees(getFormulaire().getCoach().getMatricule());
            if(getFormulaire().validation()){
                if(nbHeuresCoachDispo >= getFormulaire().getNbHeures()) {
                    PanelFormulaire3 formulaire = getFormulaire();
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
}
