package vue.inscription;

import business.CandidatService;
import business.imp.CandidatServiceImp;
import model.*;
import vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Inscription extends JPanel {
    private CardLayout layout = new CardLayout();
    private FramePrincipale frame;
    private PanelDonneesPerso panelDonneesPerso;
    private PanelAdresse panelAdresse;
    private PanelCoaching panelCoaching;
    private PanelRecap panelRecap;
    private PersonalData data;

    public Inscription(FramePrincipale frame) {
        this.frame = frame;
        this.setLayout(layout);

        panelDonneesPerso = new PanelDonneesPerso(this);
        panelAdresse = new PanelAdresse(this);
        panelCoaching = new PanelCoaching(this);
        panelRecap = new PanelRecap(this);
        add(panelDonneesPerso, "panel1");
        add(panelAdresse, "panel2");
        add(panelCoaching, "panel3");
        add(panelRecap, "recap");


        data = new PersonalData();
    }

    public void annuler(){
        frame.afficherAccueil();
    }
    public void sauverDonneesPersos(String nom, String prenom, Date dateNaissance, char sexe, String numTel, boolean estDebutant){
        data.setNom(nom);
        data.setPrenom(prenom);
        data.setDateNaissance(dateNaissance);
        data.setSexe(sexe);
        data.setNumeroGSM(numTel);
        data.setEstDebutant(estDebutant);

        layout.show(this, "panel2");
    }
    public void sauverAdresse(Adresse adresse){
        data.setAdresse(adresse);
        layout.show(this, "panel3");
    }
    public void envoyerInscription(int nbHeures, String maladies, Responsable responsable, Coach coach, Nutritionniste nutritionniste){
        data.setNbHeuresCoaching(nbHeures);
        data.setMaladiesChroniques(maladies);
        data.setResponsable(responsable);
        data.setCoach(coach);
        data.setNutri(nutritionniste);

        creerCandidat(data);
        layout.show(this, "recap");
    }

    public void resetInscription(){
        data = new PersonalData();

         layout.show(this,"panel1");
    }
    public void creerCandidat(PersonalData data){
        Candidat candidat = new Candidat(data.getNbHeuresCoaching(),
                data.getNom(), data.getPrenom(), data.getDateNaissance(),
                data.getSexe(), data.getCoach(), data.getResponsable(),data.getNutri(),  data.getAdresse());
        candidat.setNumeroGSM(data.getNumeroGSM());
        candidat.setEstDebutant(data.getEstDebutant());
        candidat.setMaladiesChroniques(data.getMaladiesChroniques());
        CandidatService candidatService = new CandidatServiceImp();
        candidatService.ajoutCandidat(candidat);
    }
}
