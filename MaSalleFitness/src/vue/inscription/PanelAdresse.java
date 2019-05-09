package vue.inscription;

import vue.inscription.formulaire.PanelFormulaire2;
import vue.listener.RetourMenuListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdresse extends PanelBase<PanelFormulaire2> {
    private Inscription inscription;
    private PanelFormulaire2 panelFormulaire2 = new PanelFormulaire2();

    public PanelAdresse(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [2/3]</h1></html>","Annuler","Suivant");
        addFormulaire(panelFormulaire2);
        this.inscription = inscription;
        setListenerBouton1(new RetourMenuListener(inscription));
        setListenerBouton2(new SuivantListener());
    }

    private class SuivantListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().validation()){
                inscription.sauverAdresse(getFormulaire().getAdresse());
            }
        }
    }
    public void rafraichir(){
        panelFormulaire2.rafraichir();
    }
}
