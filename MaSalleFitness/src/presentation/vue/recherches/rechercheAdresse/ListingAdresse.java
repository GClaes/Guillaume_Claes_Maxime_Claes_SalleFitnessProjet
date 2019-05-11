package presentation.vue.recherches.rechercheAdresse;

import model.Responsable;
import presentation.vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ListingAdresse extends JPanel {
    private FramePrincipale frame;
    private CardLayout layout = new CardLayout();
    private PanelRechercheCandidat panelRecherche;
    private PanelListeAdresses panelListeAdresses;

    public ListingAdresse(FramePrincipale frame){
        this.frame = frame;

        this.setLayout(layout);

        panelRecherche = new PanelRechercheCandidat(this);
        panelListeAdresses = new PanelListeAdresses(this);

        add(panelRecherche, "recherche");
        add(panelListeAdresses, "listing");
    }

    public void retour(){
        frame.afficherAccueil();
    }
    public void afficherListingAdresse(Responsable responsable, Date dateDebut, Date dateFin){
        panelListeAdresses.setData(responsable, dateDebut, dateFin);
        layout.show(this,"listing");
    }
    public void rafraichir(){
        panelRecherche.rafraichir();
        layout.show(this, "recherche");
    }
}
