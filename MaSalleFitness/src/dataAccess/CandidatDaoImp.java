package dataAccess;

import dataAccess.exceptions.AjouterCandidatException;
import dataAccess.exceptions.RechercherException;
import dataAccess.exceptions.SupprimerCandidatException;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidatDaoImp implements CandidatDao {
     private RowMapper<Candidat> rowMapper = new RowMapper<Candidat>() {
        @Override
        public Candidat map(ResultSet res) throws SQLException {
            Coach coach = CoachDaoImp.rowMapper.map(res);
            Responsable responsable = ResponsableDaoImp.rowMapper.map(res);
            Nutritionniste nutritionniste = NutritionnisteDaoImp.rowMapper.map(res);
            Adresse adresse = AdresseDaoImp.rowMapper.map(res);

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

            return new Candidat(nbHeuresCoaching, nom, prenom, dateNaissance, sexe, coach, responsable, nutritionniste, adresse);
        }
    };

    public Candidat rechercherCandidat(int numeroInscription) {
        Candidat candidat = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select candi.num_inscrit, candi.nom, candi.prenom, candi.date_naissance, " +
                    "candi.sexe, candi.num_gsm, candi.date_test_valide, candi.date_inscription, " +
                    "candi.nb_heures_coaching, candi.debutant, candi.maladies_chroniques, " +
                    "co.matricule, co.nom, co.prenom, co.date_debut_coaching, co.salaire_horaire, co.recompenses, " +
                    "resp.matricule, resp.nom, resp.prenom, " +
                    "nutri.num_reference, nutri.nom, nutri.prenom, nutri.avis, " +
                    "adr.code_hash, adr.localite, adr.code_postal, adr.rue, adr.numero " +
                    "from candidat candi, coach co, responsable resp, nutritionniste nutri, adresse adr " +
                    "where candi.coach_matricule = co.matricule " +
                    "and candi.responsable_matricule = resp.matricule " +
                    "and candi.nutritionniste_num_reference = nutri.num_reference " +
                    "and candi.adresse_code_hash = adr.code_hash " +
                    "and candi.num_inscrit = ?";
            statement = connection.prepareStatement(requete);
            statement.setInt(1, numeroInscription);
            res = statement.executeQuery();

            res.next();
            candidat = rowMapper.map(res);
        } catch (SQLException e) {
            throw new RechercherException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new RechercherException(e);
            }
        }

        return candidat;
    }

    public ArrayList<Candidat> listingCandidats() {
        ArrayList<Candidat> candidats = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select candi.num_inscrit, candi.nom, candi.prenom, candi.date_naissance, " +
                    "candi.sexe, candi.num_gsm, candi.date_test_valide, candi.date_inscription, " +
                    "candi.nb_heures_coaching, candi.debutant, candi.maladies_chroniques, " +
                    "co.matricule, co.nom, co.prenom, co.date_debut_coaching, co.salaire_horaire, co.recompenses, " +
                    "resp.matricule, resp.nom, resp.prenom, " +
                    "nutri.num_reference, nutri.nom, nutri.prenom, nutri.avis, " +
                    "adr.code_hash, adr.localite, adr.code_postal, adr.rue, adr.numero " +
                    "from candidat candi, coach co, responsable resp, nutritionniste nutri, adresse adr " +
                    "where candi.coach_matricule = co.matricule " +
                    "and candi.responsable_matricule = resp.matricule " +
                    "and candi.nutritionniste_num_reference = nutri.num_reference " +
                    "and candi.adresse_code_hash = adr.code_hash ";
            statement = connection.prepareStatement(requete);
            res = statement.executeQuery();

            while(res.next()) {
                candidats.add(rowMapper.map(res));
            }

        } catch (SQLException e) {
            throw new RechercherException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new RechercherException(e);
            }
        }

        return candidats;
    }

    public void ajoutCandidat(Candidat candidat) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;
        java.sql.Date sqlDate;
        AdresseDao adresseDao = new AdresseDaoImp();

        try {
            connection = SingletonConnection.getInstance();
            requete = "insert into candidat (nom, prenom, date_naissance, sexe, num_gsm, date_test_valide, " +
                    "date_inscription, nb_heures_coaching, debutant, maladies_chroniques, coach_matricule, " +
                    "responsable_matricule, nutritionnistre_num_reference, adresse_code_hash) " +
                    "values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

            statement = connection.prepareStatement(requete);

            statement.setString(1, candidat.getNom());
            statement.setString(2, candidat.getPrenom());
            sqlDate = new java.sql.Date(candidat.getDateNaissance().getTime());
            statement.setDate(3, sqlDate);
            statement.setString(4, String.valueOf(candidat.getSexe()));
            statement.setString(5, candidat.getNumeroGSM());
            sqlDate = new java.sql.Date(candidat.getDateTestValide().getTime());
            statement.setDate(6, sqlDate);
            sqlDate = new java.sql.Date(candidat.getDateInscription().getTime());
            statement.setDate(7, sqlDate);
            statement.setInt(8, candidat.getNbHeuresCoaching());
            statement.setBoolean(9, candidat.getDebutant());
            statement.setString(10, candidat.getMaladiesChroniques());
            statement.setInt(11, candidat.getCoach().getMatricule());
            statement.setInt(12, candidat.getResponsable().getNumeroTravailleur());
            statement.setInt(13, candidat.getNutritionniste().getNumReference());
            statement.setString(14, candidat.getAdresse().getCode());

            if (adresseDao.adresseExiste(candidat.getAdresse().getCode())) {
                adresseDao.ajouterAdresse(candidat.getAdresse());
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new AjouterCandidatException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new AjouterCandidatException(e);
            }
        }
    }

    public void supprimerCandidat(int numeroInscription) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;
        AdresseDao adresseDao = new AdresseDaoImp();

        try {
            connection = SingletonConnection.getInstance();

            requete = "select adresse_code_hash from candidat where num_inscrit = ?";
            statement = connection.prepareStatement(requete);
            statement.setInt(1, numeroInscription);
            res = statement.executeQuery();
            res.next();
            String code_hash = res.getString(1);

            requete = "delete from candidat where num_inscrit = ?";
            statement = connection.prepareStatement(requete);
            statement.setInt(1, numeroInscription);
            statement.executeUpdate();

            requete = "select count(*) from candidat where adresse_code_hash = ?";
            statement = connection.prepareStatement(requete);
            statement.setString(1, code_hash);
            res = statement.executeQuery();
            res.next();

            if (res.getInt(1) == 0) {
                adresseDao.supprimerAdresse(code_hash);
            }
        } catch (SQLException e) {
            throw new SupprimerCandidatException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new SupprimerCandidatException(e);
            }
        }
    }
}
