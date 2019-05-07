package business;

import dataAccess.NutritionnisteDao;
import dataAccess.NutritionnisteDaoImp;

public class NutritionnisteServiceImp implements NutritionnisteService {
    private NutritionnisteDao nutritionnisteDao;

    public NutritionnisteServiceImp() {
        setNutritionnisteDao(new NutritionnisteDaoImp());
    }

    public void setNutritionnisteDao(NutritionnisteDao nutritionnisteDao) {
        this.nutritionnisteDao = nutritionnisteDao;
    }
}
