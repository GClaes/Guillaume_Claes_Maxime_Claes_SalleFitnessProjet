package presentation.controller.listener.inscription;

import presentation.vue.inscription.Inscription;
import presentation.vue.inscription.formulaire.PanelFormulaire2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelCoachListener implements ActionListener {
    private Inscription inscription;
    private PanelFormulaire2 formulaire;

    public AccesPanelCoachListener(Inscription inscription, PanelFormulaire2 formulaire) {
        this.inscription = inscription;
        this.formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(formulaire.validation()){
            inscription.sauverAdresse(formulaire.getAdresse());
        }
    }
}
