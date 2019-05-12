package dataAccess.impl;

import dataAccess.AdresseDao;
import dataAccess.CandidatDao;
import dataAccess.exceptions.AdresseDaoException;
import dataAccess.exceptions.CandidatDaoException;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CandidatDaoImpl implements CandidatDao {
    private final AdresseDao adresseDao = AdresseDaoImpl.getInstance();
    private static CandidatDao candidatDao;

    private CandidatDaoImpl() { }

    public static CandidatDao getInstance() {
        if (candidatDao == null) {
            candidatDao = new CandidatDaoImpl();
        }
        return candidatDao;
    }

    public static final RowMapper<Candidat> rowMapper = new RowMapper<Candidat>() {
        @Override
        public Candidat map(ResultSet res) throws SQLException {
            Candidat candidat = new Candidat(
                    res.getInt("candi.nb_heures_coaching"), res.getString("candi.nom"),
                    res.getString("candi.prenom"), res.getDate("candi.date_naissance"),
                    res.getString("candi.sexe").charAt(0),
                    CoachDaoImpl.rowMapper.map(res), ResponsableDaoImpl.rowMapper.map(res), NutritionnisteDaoImpl.rowMapper.map(res),
                    AdresseDaoImpl.rowMapper.map(res)
            );

            candidat.setNumInscrit(res.getInt("candi.num_inscrit"));
            candidat.setMaladiesChroniques(res.getString("candi.maladies_chroniques"));
            candidat.setNumeroGSM(res.getString("candi.num_gsm"));
            candidat.setDateInscription(res.getDate("candi.date_inscription"));
            candidat.setDateTestValide(res.getDate("candi.date_test_valide"));
            candidat.setEstDebutant(res.getBoolean("candi.debutant"));

            return candidat;
        }
    };

    public Candidat rechercherCandidat(int numeroInscription) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from candidat candi " +
                "join coach co on candi.coach_matricule = co.matricule " +
                "join responsable resp on candi.responsable_matricule = resp.matricule " +
                "join nutritionniste nutri on candi.nutritionniste_num_reference = nutri.num_reference " +
                "join adresse adr on candi.adresse_code_hash = adr.code_hash " +
                "and candi.num_inscrit = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            statement.setInt(1, numeroInscription);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rowMapper.map(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new CandidatDaoException(e);
        }
    }

    public List<Candidat> listingCandidats() {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from candidat candi " +
                "join coach co on candi.coach_matricule = co.matricule " +
                "join responsable resp on candi.responsable_matricule = resp.matricule " +
                "join nutritionniste nutri on candi.nutritionniste_num_reference = nutri.num_reference " +
                "join adresse adr on candi.adresse_code_hash = adr.code_hash";
        List<Candidat> candidats = new ArrayList<Candidat>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    candidats.add(rowMapper.map(rs));
                }
                return candidats;
            }
        } catch (SQLException e) {
            throw new CandidatDaoException(e);
        }
    }

    public void ajouterCandidat(Candidat candidat) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "insert into candidat (nom, prenom, date_naissance, sexe, num_gsm, date_test_valide, " +
                "date_inscription, nb_heures_coaching, debutant, maladies_chroniques, coach_matricule, " +
                "responsable_matricule, nutritionniste_num_reference, adresse_code_hash) " +
                "values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            connection.setAutoCommit(false);
            statement.setString(1, candidat.getNom());
            statement.setString(2, candidat.getPrenom());
            statement.setDate(3,  new java.sql.Date(candidat.getDateNaissance().getTime()));
            statement.setString(4, String.valueOf(candidat.getSexe()));
            statement.setString(5, candidat.getNumeroGSM());

            if (candidat.getDateTestValide() != null) {
                statement.setDate(6, new java.sql.Date(candidat.getDateTestValide().getTime()));
            } else {
                statement.setDate(6, null);
            }

            statement.setDate(7, new java.sql.Date(candidat.getDateInscription().getTime()));
            statement.setInt(8, candidat.getNbHeuresCoaching());
            statement.setBoolean(9, candidat.getDebutant());
            statement.setString(10, candidat.getMaladiesChroniques());
            statement.setInt(11, candidat.getCoach().getMatricule());
            statement.setInt(12, candidat.getResponsable().getNumeroTravailleur());
            statement.setInt(13, candidat.getNutritionniste().getNumReference());
            statement.setString(14, candidat.getAdresse().getCode());

            if (!adresseDao.adresseExiste(candidat.getAdresse().getCode())) {
                adresseDao.ajouterAdresse(candidat.getAdresse());
            }

            statement.executeUpdate();
            connection.commit();
        } catch (SQLException | AdresseDaoException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new CandidatDaoException(e1);
            }
            throw new CandidatDaoException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new CandidatDaoException(e);
            }
        }

    }

    public void supprimerCandidat(int numeroInscription) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "delete from candidat where num_inscrit = ?";

        Candidat candidat = rechercherCandidat(numeroInscription);
        if (candidat != null) {
            try (PreparedStatement statement = connection.prepareStatement(requete)) {
                connection.setAutoCommit(false);
                statement.setInt(1, numeroInscription);
                statement.executeUpdate();

                if (!adresseDao.adresseUtilisee(candidat.getAdresse().getCode())) {
                    adresseDao.supprimerAdresse(candidat.getAdresse().getCode());
                }
                connection.commit();
            } catch (SQLException | AdresseDaoException e) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    throw new CandidatDaoException(e1);
                }
                throw new CandidatDaoException(e);
            } finally {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    throw new CandidatDaoException(e);
                }
            }
        }
    }

    public void modifierCandidat(Candidat candidat) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "update candidat set nom = ?, prenom = ?, date_naissance = ?, sexe = ?, num_gsm = ?, " +
                "date_test_valide = ?, date_inscription = ?, nb_heures_coaching = ?, debutant = ?, " +
                "maladies_chroniques = ?, coach_matricule = ?, responsable_matricule = ?, " +
                "nutritionniste_num_reference = ?, adresse_code_hash = ? where num_inscrit = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            connection.setAutoCommit(false);
            statement.setString(1, candidat.getNom());
            statement.setString(2, candidat.getPrenom());
            statement.setDate(3, new java.sql.Date(candidat.getDateNaissance().getTime()));
            statement.setString(4, String.valueOf(candidat.getSexe()));
            statement.setString(5, candidat.getNumeroGSM());

            if (candidat.getDateTestValide() != null) {
                statement.setDate(6, new java.sql.Date(candidat.getDateTestValide().getTime()));
            } else {
                statement.setDate(6, null);
            }

            statement.setDate(7, new java.sql.Date(candidat.getDateInscription().getTime()));
            statement.setInt(8, candidat.getNbHeuresCoaching());
            statement.setBoolean(9, candidat.getDebutant());
            statement.setString(10, candidat.getMaladiesChroniques());
            statement.setInt(11, candidat.getCoach().getMatricule());
            statement.setInt(12, candidat.getResponsable().getNumeroTravailleur());
            statement.setInt(13, candidat.getNutritionniste().getNumReference());
            statement.setString(14, candidat.getAdresse().getCode());
            statement.setInt(15, candidat.getNumInscription());

            String ancienCodeAdresse = rechercherCandidat(candidat.getNumInscription()).getAdresse().getCode();

            if (!adresseDao.adresseExiste(candidat.getAdresse().getCode())) {
                adresseDao.ajouterAdresse(candidat.getAdresse());
            }

            statement.executeUpdate();
            if (candidat.getAdresse().getCode().compareTo(ancienCodeAdresse) != 0) {
                if (!adresseDao.adresseUtilisee(ancienCodeAdresse)) {
                    adresseDao.supprimerAdresse(ancienCodeAdresse);
                }
            }
            connection.commit();
        } catch (SQLException | AdresseDaoException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new CandidatDaoException(e1);
            }
            throw new CandidatDaoException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new CandidatDaoException(e);
            }
        }
    }

    /**
     *
     * @param responsableMatricule
     * @param debut
     * @param fin
     * @return liste des candidats inscrits entre deux dates par un responsable
     */
    public List<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from candidat candi " +
                "join coach co on candi.coach_matricule = co.matricule " +
                "join responsable resp on candi.responsable_matricule = resp.matricule " +
                "join nutritionniste nutri on candi.nutritionniste_num_reference = nutri.num_reference " +
                "join adresse adr on candi.adresse_code_hash = adr.code_hash " +
                "and candi.date_inscription between ? and ?" +
                "and resp.matricule = ?";
        List<Candidat> candidats = new ArrayList<Candidat>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            statement.setDate(1, new java.sql.Date(debut.getTime()));
            statement.setDate(2, new java.sql.Date(fin.getTime()));
            statement.setInt(3, responsableMatricule);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    candidats.add(rowMapper.map(rs));
                }
                return candidats;
            }
        } catch (SQLException e) {
            throw new CandidatDaoException(e);
        }
    }

    public List<Candidat> candidatsDUnCoach(Coach coach) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from candidat candi " +
                "join coach co on candi.coach_matricule = co.matricule " +
                "join responsable resp on candi.responsable_matricule = resp.matricule " +
                "join nutritionniste nutri on candi.nutritionniste_num_reference = nutri.num_reference " +
                "join adresse adr on candi.adresse_code_hash = adr.code_hash " +
                "where candi.coach_matricule = ?";

        List<Candidat> candidats = new ArrayList<Candidat>();

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setInt(1, coach.getMatricule());

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    candidats.add(rowMapper.map(rs));
                }
                return candidats;
            }
        } catch (SQLException e) {
            throw new CandidatDaoException(e);
        }
    }

    public List<Candidat> candidatsDUnNutritionniste(Nutritionniste nutritionniste) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from candidat candi " +
                "join coach co on candi.coach_matricule = co.matricule " +
                "join responsable resp on candi.responsable_matricule = resp.matricule " +
                "join nutritionniste nutri on candi.nutritionniste_num_reference = nutri.num_reference " +
                "join adresse adr on candi.adresse_code_hash = adr.code_hash " +
                "where candi.nutritionniste_num_reference = ?";

        List<Candidat> candidats = new ArrayList<Candidat>();

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setInt(1, nutritionniste.getNumReference());

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    candidats.add(rowMapper.map(rs));
                }
                return candidats;
            }
        } catch (SQLException e) {
            throw new CandidatDaoException(e);
        }
    }
}
