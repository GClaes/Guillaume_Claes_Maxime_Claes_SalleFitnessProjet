package presentation.controleurs.inscription;

import presentation.vue.inscription.Inscription;
import presentation.vue.inscription.formulaire.FormulaireAdresse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelCoachListener implements ActionListener {
    private Inscription inscription;
    private FormulaireAdresse formulaire;

    public AccesPanelCoachListener(Inscription inscription, FormulaireAdresse formulaire) {
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
