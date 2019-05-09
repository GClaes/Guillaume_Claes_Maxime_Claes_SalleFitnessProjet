package dataAccess.imp;

import dataAccess.NutritionnisteDao;
import dataAccess.RowMapper;
import dataAccess.exceptions.ListingException;
import dataAccess.exceptions.NutritionnistesParCandidatsParCoachException;
import model.Nutritionniste;

import java.sql.*;
import java.util.ArrayList;

public class NutritionnisteDaoImp implements NutritionnisteDao {
    private static NutritionnisteDao nutritionnisteDao;

    private NutritionnisteDaoImp() { }

    public static NutritionnisteDao getInstance() {
        if (nutritionnisteDao == null) {
            nutritionnisteDao = new NutritionnisteDaoImp();
        }
        return nutritionnisteDao;
    }

    public static RowMapper<Nutritionniste> rowMapper = new RowMapper<Nutritionniste>() {
        @Override
        public Nutritionniste map(ResultSet res) throws SQLException {
            return new Nutritionniste(res.getInt("nutri.num_reference"), res.getString("nutri.nom"), res.getString("nutri.prenom"), res.getString("nutri.avis"));
        }
    };

    public ArrayList<Nutritionniste> listingNutritionnistes() {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from nutritionniste nutri";
        ArrayList<Nutritionniste> nutritionnistes = new ArrayList<Nutritionniste>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            try (ResultSet rs  = statement.executeQuery()) {
                while(rs.next()) {
                    nutritionnistes.add(rowMapper.map(rs));
                }
                return nutritionnistes;
            }
        } catch (SQLException e) {
            throw new ListingException(e);
        }
    }

    /**
     *
     * @param coachMatricule
     * @return liste des nutritionnistes qui ont été choisis par les candidats qui eux-mêmes sont entrainés par un coach donné
     */
    public ArrayList<Nutritionniste> nutritionnistesDesCandidatsEntrainesParUnCoach(int coachMatricule) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * " +
                "from candidat candi, coach co, responsable resp, nutritionniste nutri, adresse adr " +
                "where candi.coach_matricule = co.matricule " +
                "and candi.responsable_matricule = resp.matricule " +
                "and candi.nutritionniste_num_reference = nutri.num_reference " +
                "and candi.adresse_code_hash = adr.code_hash " +
                "and co.matricule = ?";

        ArrayList<Nutritionniste> nutritionnistes = new ArrayList<Nutritionniste>();
        Nutritionniste nutritionnisteAjout;

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setInt(1, coachMatricule);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    nutritionnisteAjout = rowMapper.map(rs);

                    int indice = contientNutritionniste(nutritionnistes, nutritionnisteAjout);
                    if (indice == -1) {
                        nutritionnisteAjout.ajouterCandidat(CandidatDaoImp.rowMapper.map(rs));
                        nutritionnistes.add(nutritionnisteAjout);
                    } else {
                        nutritionnistes.get(indice).ajouterCandidat(CandidatDaoImp.rowMapper.map(rs));
                    }
                }
                return nutritionnistes;
            }
        } catch (SQLException e) {
            throw new NutritionnistesParCandidatsParCoachException(e);
        }
    }

    private int contientNutritionniste(ArrayList<Nutritionniste> nutritionnistes, Nutritionniste nutritionnisteRech) {
        for (int i = 0 ; i < nutritionnistes.size() ; i++) {
            if (nutritionnistes.get(i).getNumReference() == nutritionnisteRech.getNumReference()) {
                return i;
            }
        }
        return -1;
    }
}
