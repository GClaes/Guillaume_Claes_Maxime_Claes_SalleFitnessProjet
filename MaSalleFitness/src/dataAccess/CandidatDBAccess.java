package dataAccess;

import dataAccess.exceptions.AjoutCandidatException;
import model.*;

import java.sql.*;

public class CandidatDBAccess implements CandidatDataAccess {
    public void modifierCandidat(Candidat candidat) throws AjoutCandidatException {
        PreparedStatement statement = null;

        try (Connection connection = SingletonConnection.getInstance()) {
            if (candidat.getNumInscription() == null) {
                String requete = "INSERT INTO candidat (num_inscrit, nom, prenom, date_naissance, " +
                        "sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, " +
                        "debutant, maladies_chroniques, coach_matricule, responsable_matricule, " +
                        "nutritionnistre_num_reference, adresse_code_hach) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

                java.sql.Date sqlDate;
                statement = connection.prepareStatement(requete);

                statement.setInt(1, candidat.getNumInscription());
                statement.setString(2, candidat.getNom());
                statement.setString(3, candidat.getPrenom());
                sqlDate = new java.sql.Date(candidat.getDateNaissance().getTime());
                statement.setDate(4, sqlDate);
                statement.setString(5, String.valueOf(candidat.getSexe()));
                statement.setString(6, candidat.getNumeroGSM());
                sqlDate = new java.sql.Date(candidat.getDateTestValide().getTime());
                statement.setDate(7, sqlDate);
                sqlDate = new java.sql.Date(candidat.getDateInscription().getTime());
                statement.setDate(8, sqlDate);
                statement.setInt(9, candidat.getNbHeuresCoaching());
                statement.setBoolean(10, candidat.getDebutant());
                statement.setString(11, candidat.getMaladiesChroniques());
                statement.setInt(12, candidat.getCoach().getMatricule());
                statement.setInt(13, candidat.getResponsable().getNumeroTravailleur());
                statement.setInt(14, candidat.getNutritionniste().getNumReference());
                statement.setString(15, candidat.getAdresse().getCode());

                int nbLignesModifiees = statement.executeUpdate();      //Genere une exception

            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                //resultSet.close();
            } catch (SQLException e) {
                throw new AjoutCandidatException(e);
            }
        }
    }

    public Candidat rechercheCandidat(int numeroInscription) throws AjoutCandidatException {
        Candidat candidat = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "SELECT * FROM candidat WHERE num_inscrit = ?";
            statement = connection.prepareStatement(requete);
            statement.setInt(1, 90419);
            res = statement.executeQuery();

            res.next();
            int numInscription = res.getInt("num_inscrit");
            String nom = res.getString("nom");
            String prenom = res.getString("prenom");
            java.util.Date dateNaissance = res.getTimestamp("date_naissance");
            char sexe = res.getString("sexe").charAt(0);
            String numeroGSM = res.getString("num_gsm");
            java.util.Date dateTestValide = res.getTimestamp("date_test_valide");
            java.util.Date dateInscription = res.getTimestamp("date_inscription");
            int nbHeuresCoaching = res.getInt("nb_heures_coaching");
            boolean estDebutant = res.getBoolean("debutant");
            String maladiesChroniques = res.getString("maladies_chroniques");
            int coachMatricule = res.getInt("coach_matricule");
            int responsableMatricule = res.getInt("responsable_matricule");
            int nutritionnisteNumReference = res.getInt("nutritionniste_num_reference");
            String adresseCodeHach = res.getString("adresse_code_hach");


            requete = "SELECT * FROM coach WHERE matricule = ?";
            statement = connection.prepareStatement(requete);
            statement.setInt(1, coachMatricule);
            res = statement.executeQuery();

            res.next();
            java.util.Date utilDate = res.getTimestamp("date_debut_coaching");
            Coach coach = new Coach(res.getInt("matricule"), res.getString("nom"), res.getString("prenom"), res.getString("recompenses"), res.getInt("salaire_horaire"), utilDate);  //getDouble pour le salaireHoraire


            requete = "SELECT * FROM responsable WHERE matricule = ?";
            statement = connection.prepareStatement(requete);
            statement.setInt(1, responsableMatricule);
            res = statement.executeQuery();

            res.next();
            Responsable responsable = new Responsable(res.getInt("matricule"), res.getString("nom"), res.getString("prenom"));


            requete = "SELECT * FROM nutritionniste WHERE num_reference = ?";
            statement = connection.prepareStatement(requete);
            statement.setInt(1, nutritionnisteNumReference);
            res = statement.executeQuery();

            res.next();
            Nutritionniste nutritionniste = new Nutritionniste(res.getInt("num_reference"), res.getString("nom"), res.getString("prenom"), res.getString("avis"));


            requete = "SELECT * FROM adresse WHERE code_hach = ?";
            statement = connection.prepareStatement(requete);
            statement.setString(1, adresseCodeHach);
            res = statement.executeQuery();

            res.next();
            Adresse adresse = new Adresse(res.getString("localite"), res.getString("code_postal"), res.getString("rue"), res.getString("numero"));
            adresse.setCode(res.getString("code_hach"));


            candidat = new Candidat(nbHeuresCoaching, nom, prenom, dateNaissance, sexe, coach, responsable, nutritionniste, adresse);

        } catch (SQLException e) {
            throw new AjoutCandidatException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new AjoutCandidatException(e);
            }
        }

        return candidat;
    }
}
