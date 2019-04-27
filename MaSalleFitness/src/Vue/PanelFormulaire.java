package Vue;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class PanelFormulaire extends JPanel {
    private JLabel nomLabel, prénomLabel, numTelLabel,sexeLabel , experienceLabel, dateNaissanceLabel;
    private JTextField nom, prénom, numTel;
    private JComboBox sexe, experience;
    private Font gras;
    SpinnerDateModel dateModel;
    JSpinner dateNaissance;

    public PanelFormulaire() {
        setLayout(new GridLayout(6, 2,25,25));


        //INSTANCIATION
        gras = new Font("Gras",Font.BOLD,20);

        //NOM
        nomLabel = new JLabel("Nom");
        nomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nomLabel.setFont(gras);
        nom = new JTextField(30);
        nom.setFont(gras);

        prénomLabel = new JLabel("Prénom");
        prénomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        prénomLabel.setFont(gras);
        prénom = new JTextField(30);
        prénom.setFont(gras);

        //SEXE
        sexeLabel = new JLabel("Sexe");
        sexeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sexeLabel.setFont(gras);
        String[] valuesSexe = {"Homme","Femme"};
        sexe = new JComboBox(valuesSexe);
        sexe.setFont(gras);
        sexe.setSelectedItem("Homme");

        //DATE NAISSANCE
        dateNaissanceLabel = new JLabel("Date de naissance");
        dateNaissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateNaissanceLabel.setFont(gras);
        dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dateNaissance = new JSpinner(dateModel);
        dateNaissance.setEditor(new JSpinner.DateEditor(dateNaissance,"dd - MM - yyyy"));
        dateNaissance.setFont(gras);

        //NULLABLE
        numTelLabel = new JLabel("Numéro de téléphone (0123456789)");
        numTelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numTelLabel.setFont(gras);
        numTel = new JTextField("0", 30);
        numTel.setFont(gras);

        //EXPERIENCE
        experienceLabel = new JLabel("Avez-vous de l'expérience dans les salles de sport?");
        experienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        experienceLabel.setFont(gras);
        String[] valuesExp = {"Non","Oui"};
        experience = new JComboBox(valuesExp);
        experience.setFont(gras);
        experience.setSelectedItem("Non");


        //AJOUTS
        this.add(nomLabel);
        this.add(nom);
        this.add(prénomLabel);
        this.add(prénom);
        this.add(sexeLabel);
        this.add(sexe);
        this.add(dateNaissanceLabel);
        this.add(dateNaissance);
        this.add(numTelLabel);
        this.add(numTel);
        this.add(experienceLabel);
        this.add(experience);

    }

    public String getNom() {
        return nom.getText();
    }

    public String getPrénom() {
        return prénom.getText();
    }

    public String getNumTel() {
        return numTel.getText();
    }

    public int getSexe() {
        return sexe.getSelectedIndex();
    }

    public int getExperience() {
        return experience.getSelectedIndex();
    }

    public Date getDateNaissance() {
        return (Date) dateNaissance.getValue();
    }

    public JLabel getNomLabel() {
        return nomLabel;
    }

    public JLabel getPrénomLabel() {
        return prénomLabel;
    }

    public JLabel getNumTelLabel() {
        return numTelLabel;
    }

    public JLabel getDateNaissanceLabel() {
        return dateNaissanceLabel;
    }

    public void setNomLabel(JLabel nomLabel) {
        this.nomLabel = nomLabel;
    }
}
