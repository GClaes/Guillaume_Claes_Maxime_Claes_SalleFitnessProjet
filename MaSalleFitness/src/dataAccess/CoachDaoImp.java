package dataAccess;

import dataAccess.exceptions.*;
import model.Candidat;
import model.Coach;

import java.sql.*;
import java.util.ArrayList;

public class CoachDaoImp implements CoachDao {
    private static CoachDaoImp coachDaoImp;
    public CandidatDao candidatDao = CandidatDaoImp.getInstance();

    private CoachDaoImp() { }

    public static CoachDaoImp getInstance() {
        if (coachDaoImp == null) {
            coachDaoImp = new CoachDaoImp();
        }
        return coachDaoImp;
    }

    public static RowMapper<Coach> rowMapper = new RowMapper<Coach>() {
        @Override
        public Coach map(ResultSet res) throws SQLException {
            java.util.Date utilDate = res.getTimestamp("co.date_debut_coaching");
            return new Coach(res.getInt("co.matricule"), res.getString("co.nom"), res.getString("co.prenom"), res.getString("co.recompenses"), res.getDouble("co.salaire_horaire"), utilDate);  //getDouble pour le salaireHoraire
        }
    };

    public ArrayList<Coach> listingCoach() {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from coach co";
        ArrayList<Coach> coachs = new ArrayList<Coach>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    coachs.add(rowMapper.map(rs));
                }
                return coachs;
            }
        } catch (SQLException e) {
            throw new ListingException(e);
        }
    }

    /**
     *
     * @param matriculeCoach
     * @return nombre d'heures du coach ou -1 si le coach n'existe pas
     */
    public int nbHeuresCoachingUtilisees(int matriculeCoach) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select sum(candi.nb_heures_coaching) from candidat candi, coach co " +
                "where candi.coach_matricule = co.matricule " +
                "and co.matricule = ?";
        int nbHeuresCoaching = -1;

        if (coachExiste(matriculeCoach)) {
            try (PreparedStatement statement  = connection.prepareStatement(requete)) {
                statement.setInt(1, matriculeCoach);

                try (ResultSet rs = statement.executeQuery()) {
                    rs.next();
                    nbHeuresCoaching = rs.getInt(1);
                }
            } catch (SQLException e) {
                throw new NbHeuresCoachingUtiliseesException(e);
            }
        }

        return nbHeuresCoaching;
    }

    public boolean coachExiste(int matriculeCoach) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select count(*) from coach where matricule = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            statement.setInt(1, matriculeCoach);

            try (ResultSet rs = statement.executeQuery()){
                rs.next();
                return rs.getInt(1) == 1;
            }
        } catch (SQLException e) {
            throw new CoachExisteException(e);
        }
    }

    /**
     *
     * @param matriculeCoach
     * @return si coach existe, return coach ; sinon return null
     */
    public Coach obtentionCoach(int matriculeCoach) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from coach co where matricule = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setInt(1, matriculeCoach);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rowMapper.map(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new ObtentionCoachException(e);
        }
    }

    /**
     *
     * @param responsableMatricule
     * @return Retourne une liste des coachs qui ont été choisis par les candidats qui eux-mêmes ont été inscrit par un responsable
     */
    public ArrayList<Coach> coachsParCandidatsParResponsable(int responsableMatricule) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * " +
                "from candidat candi, coach co, responsable resp, nutritionniste nutri, adresse adr " +
                "where candi.coach_matricule = co.matricule " +
                "and candi.responsable_matricule = resp.matricule " +
                "and candi.nutritionniste_num_reference = nutri.num_reference " +
                "and candi.adresse_code_hash = adr.code_hash " +
                "and resp.matricule = ?";

        ArrayList<Coach> coachs = new ArrayList<Coach>();
        Coach coachAjout;

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setInt(1, responsableMatricule);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    coachAjout = rowMapper.map(rs);

                    int indice = contientCoach(coachs, coachAjout);
                    if (indice == -1) {
                        coachAjout.ajouterCandidat(CandidatDaoImp.rowMapper.map(rs));
                        coachs.add(coachAjout);
                    } else {
                        coachs.get(indice).ajouterCandidat(CandidatDaoImp.rowMapper.map(rs));
                    }
                }
                return coachs;
            }
        } catch (SQLException e) {
            throw new CoachsParCandidatsParResponsableException(e);
        }
    }

    /**
     *
     * @param coachs
     * @param coachRech
     * @return l'index du coach, ou -1 si la liste ne contient pas l'élément
     */
    private int contientCoach(ArrayList<Coach> coachs, Coach coachRech) {
        for (int i = 0 ; i < coachs.size() ; i++) {
            if (coachs.get(i).getMatricule() == coachRech.getMatricule()) {
                return i;
            }
        }
        return -1;
    }

}
