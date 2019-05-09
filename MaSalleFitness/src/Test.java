import business.CandidatServiceImp;
import dataAccess.*;
import model.Adresse;
import model.Candidat;
import model.Coach;
import model.Nutritionniste;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        NutritionnisteDao dao = NutritionnisteDaoImp.getInstance();
        ArrayList<Nutritionniste> nutritionnistes = dao.nutritionnistesParCandidatsParCoach(1);

        for (int i = 0 ; i < nutritionnistes.size() ; i++) {
            System.out.println(nutritionnistes.get(i).getNom());
            for (int j = 0 ; j < nutritionnistes.get(i).getCandidats().size() ; j++) {
                System.out.println(nutritionnistes.get(i).getCandidats().get(j).getAdresse().getCode());
            }
        }
    }

}
