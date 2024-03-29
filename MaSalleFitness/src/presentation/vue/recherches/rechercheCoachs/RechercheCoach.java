package presentation.vue.recherches.rechercheCoachs;

import model.Responsable;
import presentation.vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;

public class RechercheCoach extends JPanel {
    private FramePrincipale frame;
    private CardLayout layout = new CardLayout();
    private PanelRechercheResponsable panelListeResponsable;
    private PanelListeCoachs panelListeCoachs;

    public RechercheCoach(FramePrincipale frame) {
        this.frame = frame;

        this.setLayout(layout);

    }

    public void afficherListingCoach(Responsable responsable){
        panelListeCoachs.setResponsable(responsable);
        layout.show(this, "coach");
    }

    public void retour(){
        frame.afficherAccueil();
    }
    public void rafraichir(){
        panelListeResponsable = new PanelRechercheResponsable(this);
        panelListeCoachs = new PanelListeCoachs(this);
        add(panelListeResponsable, "responsable");
        add(panelListeCoachs, "coach");
        panelListeResponsable.rafraichir();
        layout.show(this,"responsable");
    }
}
