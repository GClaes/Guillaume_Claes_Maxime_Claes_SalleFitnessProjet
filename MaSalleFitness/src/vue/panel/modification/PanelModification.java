package vue.panel.modification;

import business.CandidatService;
import business.CandidatServiceImp;
import model.Candidat;
import vue.panel.PanelMenu;
import vue.panel.inscription.PanelInscriptionBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModification extends PanelInscriptionBase<PanelModificationFormulaire> {

    public PanelModification(Candidat candidat) {
        super("<html><h1>Modification d'un candidat</h1></html>", "Valider", new PanelModificationFormulaire(candidat));
        setListener(new ValiderListener());
    }

    private class ValiderListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().validation()){
                PanelModificationFormulaire formulaire = getFormulaire();
                creerCandidat(formulaire);


                PanelModification.this.removeAll();
                JLabel texteEnvoi = new JLabel("<html><h1>Candidature modifiée avec succès!</h1></html>");
                JButton ok = new JButton("Ok");
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PanelModification.this.removeAll();
                        PanelModification.this.add(new PanelMenu());
                        PanelModification.this.repaint();
                        PanelModification.this.revalidate();

                    }
                });
                texteEnvoi.setBounds(150, 80, 500, 150);
                ok.setBounds(350, 500, 100, 40);
                texteEnvoi.setHorizontalAlignment(SwingConstants.CENTER);
                PanelModification.this.add(texteEnvoi);
                PanelModification.this.add(ok);
                PanelModification.this.repaint();
            }
        }
    }
    public void creerCandidat(PanelModificationFormulaire formulaire){

        Candidat candidat = new Candidat(formulaire.getNbHeures(),
                formulaire.getNom(), formulaire.getPrenom(), formulaire.getDateNaissance(),
                formulaire.getSexe(), formulaire.getCoach(), formulaire.getResponsable(),formulaire.getNutri(),
                formulaire.getAdresse());
        candidat.setNumeroGSM(formulaire.getNumero());
        candidat.setEstDebutant(formulaire.getExp());
        candidat.setMaladiesChroniques(formulaire.getMaladies());

        CandidatService candidatService = new CandidatServiceImp();
        candidatService.ajoutCandidat(candidat);
    }
}
