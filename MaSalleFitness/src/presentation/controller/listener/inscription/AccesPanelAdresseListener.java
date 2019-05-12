package presentation.controller.listener.inscription;

import presentation.vue.inscription.Inscription;
import presentation.vue.inscription.formulaire.PanelFormulaire;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelAdresseListener implements ActionListener {
    private Inscription inscription;
    private PanelFormulaire formulaire;
    public AccesPanelAdresseListener(Inscription inscription, PanelFormulaire formulaire){
        this.inscription = inscription;
        this.formulaire =formulaire;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(formulaire.validation()) {
            inscription.sauverDonneesPersos(formulaire.getNom(),
                    formulaire.getPrenom(),
                    formulaire.getDateNaissance(),
                    formulaire.getSexe(),
                    formulaire.getNumTel(),
                    formulaire.getExp()
            );
        }
    }
}
