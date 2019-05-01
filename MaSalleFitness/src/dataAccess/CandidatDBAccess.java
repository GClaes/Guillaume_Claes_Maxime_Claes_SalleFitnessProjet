package dataAccess;

import dataAccess.exceptions.AjoutCandidatException;
import model.Candidat;

import java.sql.*;

public class CandidatDBAccess implements CandidatDataAccess {
    public void ajoutCandidat(Candidat candidat) throws AjoutCandidatException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = SingletonConnection.getInstance();      //A mettre dans le main

            String requete = "INSERT INTO candidat (num_inscrit, nom, prenom, date_naissance, " +
                    "sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, " +
                    "debutant, maladies_chroniques, coach_matricule, responsable_matricule, " +
                    "nutritionnistre_num_reference, adresse_code_hach) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

            java.sql.Date sqlDate;
            statement = connection.prepareStatement(requete);

            statement.setInt(1, candidat.getNumInscription());
            statement.setString(2, Candidat.getNom());
            statement.setString(3, Candidat.getPrenom());
            sqlDate = candidat.getDateNaissance();
            statement.setDate(4, sqlDate);
            statement.setString(5, candidat.getSexe());
            statement.setString(6, candidat.getNumeroGSM());
            sqlDate = candidat.getDateTestValide();
            statement.setDate(7, sqlDate);
            sqlDate = candidat.getDateInscription();
            statement.setDate(8, sqlDate);
            statement.setInt(9, candidat.getNbHeuresCoaching());
            statement.setBoolean(10, candidat.getDebutant());
            statement.setString(11, candidat.getMaladiesChroniques());
            statement.setInt(12, candidat.getCoach().getMatricule());
            statement.setInt(13, candidat.getResponsable().getNumeroTravailleur());
            statement.setInt(14, candidat.getNutritionniste().getNumReference());
            statement.setString(15, candidat.getAdresse().getCode());

            int nbLignesModifiees = statement.executeUpdate();

            //ResultSet res = stmt.executeQuery(requete);
        } catch (SQLException e) {
            throw new AjoutCandidatException();
        }
        finally {
            try {
                connection.close();
                statement.close();
                //resultSet.close();
            } catch (SQLException e) {
                throw new AjoutCandidatException();
            }
        }
    }
}
