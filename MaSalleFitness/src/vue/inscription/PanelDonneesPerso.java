package vue.inscription;

import vue.inscription.formulaire.PanelFormulaire;
import vue.listener.RetourMenuListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDonneesPerso extends PanelBase<PanelFormulaire> {
    private Inscription inscription;
    private PanelFormulaire panelFormulaire = new PanelFormulaire();

    public PanelDonneesPerso(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [1/3]</h1></html>", "Annuler", "Suivant");
        addFormulaire(panelFormulaire);
        this.inscription = inscription;
        setListenerBouton1(new RetourMenuListener(inscription));
        setListenerBouton2(new SuivantListener());

    }


    private class SuivantListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().validation()) {
                PanelFormulaire formulaire = getFormulaire();
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
    public void rafraichir(){
        panelFormulaire.rafraichir();
    }

}
