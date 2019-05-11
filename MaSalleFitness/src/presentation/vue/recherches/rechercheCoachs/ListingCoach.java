package presentation.vue.recherches.rechercheCoachs;

import model.Responsable;
import presentation.vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;

public class ListingCoach extends JPanel {
    private FramePrincipale frame;
    private CardLayout layout = new CardLayout();
    private PanelRechercheResponsable panelListeResponsable;
    private PanelListeCoachs panelListeCoachs;

    public ListingCoach(FramePrincipale frame) {
        this.frame = frame;

        this.setLayout(layout);

        panelListeResponsable = new PanelRechercheResponsable(this);
        panelListeCoachs = new PanelListeCoachs(this);

        add(panelListeResponsable, "responsable");
        add(panelListeCoachs, "coach");
    }

    public void afficherListingCoach(Responsable responsable){
        panelListeCoachs.setResponsable(responsable);
        layout.show(this, "coach");
    }

    public void retour(){
        frame.afficherAccueil();
    }
    public void rafraichir(){
        panelListeResponsable.rafraichir();
        layout.show(this,"responsable");
    }
}
