package business.impl;

import business.NutritionnisteService;
import dataAccess.NutritionnisteDao;
import dataAccess.impl.NutritionnisteDaoImpl;
import model.Nutritionniste;

import java.util.List;

public class NutritionnisteServiceImpl implements NutritionnisteService {
    private final NutritionnisteDao nutritionnisteDao = NutritionnisteDaoImpl.getInstance();
    private static NutritionnisteService nutritionnisteService;

    private NutritionnisteServiceImpl() { }

    public static NutritionnisteService getInstance() {
        if (nutritionnisteService == null) {
            nutritionnisteService = new NutritionnisteServiceImpl();
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
