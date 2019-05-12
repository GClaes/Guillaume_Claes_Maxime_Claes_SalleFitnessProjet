package presentation.controleurs.inscription;

import presentation.vue.inscription.Inscription;
import presentation.vue.inscription.formulaire.FormulaireDonneesPerso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelAdresseListener implements ActionListener {
    private Inscription inscription;
    private FormulaireDonneesPerso formulaire;
    public AccesPanelAdresseListener(Inscription inscription, FormulaireDonneesPerso formulaire){
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
