package business.imp;

import business.NutritionnisteService;
import dataAccess.NutritionnisteDao;
import dataAccess.imp.NutritionnisteDaoImp;
import model.Nutritionniste;

import java.util.List;

public class NutritionnisteServiceImp implements NutritionnisteService {
    private final NutritionnisteDao nutritionnisteDao = NutritionnisteDaoImp.getInstance();
    private static NutritionnisteService nutritionnisteService;

    private NutritionnisteServiceImp() { }

    public static NutritionnisteService getInstance() {
        if (nutritionnisteService == null) {
            nutritionnisteService = new NutritionnisteServiceImp();
        }
        return nutritionnisteService;
    }

    public List<Nutritionniste> listingNutritionnistes() {
        return nutritionnisteDao.listingNutritionnistes();
    }

    public List<Nutritionniste> nutritionnistesDesCandidatsEntrainesParUnCoach(int coachMatricule) {
        return nutritionnisteDao.nutritionnistesDesCandidatsEntrainesParUnCoach(coachMatricule);
    }
}
