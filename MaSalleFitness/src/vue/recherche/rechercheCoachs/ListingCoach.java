package vue.recherche.rechercheCoachs;

import model.Responsable;
import vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;

public class ListingCoach extends JPanel {
    private FramePrincipale frame;
    private CardLayout layout = new CardLayout();
    private PanelListeResponsables panelListeResponsable;
    private PanelListeCoachs panelListeCoachs;

    public ListingCoach(FramePrincipale frame) {
        this.frame = frame;

        this.setLayout(layout);

        panelListeResponsable = new PanelListeResponsables(this);
        panelListeCoachs = new PanelListeCoachs(this);

        add(panelListeResponsable, "responsable");
        add(panelListeCoachs, "coach");
    }

    public void afficherListingCoach(Responsable responsable){
        panelListeCoachs.setResponsable(responsable);
        layout.show(panelListeCoachs, "coach");
    }

    public void retour(){
        frame.afficherAccueil();
    }
    public void rafraichir(){
        panelListeResponsable.rafraichir();
        layout.show(this,"responsable");
    }
}
