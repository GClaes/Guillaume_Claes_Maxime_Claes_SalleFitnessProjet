package vue.inscription;

import vue.inscription.formulaire.PanelFormulaire3;
import vue.listener.RetourMenuListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCoaching extends PanelBase<PanelFormulaire3> {
    private Inscription inscription;

    public PanelCoaching(Inscription inscription) {
        super("<html><h1>Inscription nouveau recherche [3/3]</h1></html>", "Annuler","Envoyer",new PanelFormulaire3());
        this.inscription = inscription;
        setListenerBouton1(new RetourMenuListener(inscription));
        setListenerBouton2(new EnvoyerListener());
    }

    public class EnvoyerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().validation()){
                PanelFormulaire3 formulaire = getFormulaire();
                inscription.envoyerInscription(
                        formulaire.getNbHeures(),
                        formulaire.getMaladies(),
                        formulaire.getResponsable(),
                        formulaire.getCoach(),
                        formulaire.getNutri());
            }
        }
    }
}
