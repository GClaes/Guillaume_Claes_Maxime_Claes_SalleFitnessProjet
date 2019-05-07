package vue.panel.inscription;

import business.CandidatService;
import business.CandidatServiceImp;
import model.Candidat;
import vue.panel.PanelMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelInscription3 extends PanelInscriptionBase<PanelFormulaire3> {
    private PersonalData data;

    public PanelInscription3(PersonalData data){
        super("<html><h1>Inscription nouveau candidat [3/3]</h1></html>", "Envoyer",new PanelFormulaire3());
        setListener(new EnvoyerListener());
        this.data = data;
    }

    private class EnvoyerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().validation()){
                PanelFormulaire3 formulaire = getFormulaire();
                data.setNbHeuresCoaching(formulaire.getNbHeures());
                data.setMaladiesChroniques(formulaire.getMaladies());
                data.setResponsable(formulaire.getResponsable());
                data.setCoach(formulaire.getCoach());
                data.setNutri(formulaire.getNutri());

                //CREATION CANDIDAT
                creerCandidat(data);


                PanelInscription3.this.removeAll();
                JLabel texteEnvoi = new JLabel("<html><h2>Candidature envoyée avec succès!</h2></html>");
                JButton ok = new JButton("Ok");
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PanelInscription3.this.removeAll();
                        PanelInscription3.this.add(new PanelMenu());
                        PanelInscription3.this.repaint();
                        PanelInscription3.this.revalidate();

                    }
                });
                texteEnvoi.setBounds(150, 80, 500, 150);
                ok.setBounds(350, 500, 100, 40);
                texteEnvoi.setHorizontalAlignment(SwingConstants.CENTER);
                PanelInscription3.this.add(texteEnvoi);
                PanelInscription3.this.add(ok);
                PanelInscription3.this.repaint();
            }
        }
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
