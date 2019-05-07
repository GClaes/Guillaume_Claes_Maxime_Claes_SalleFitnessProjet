package business;

import dataAccess.NutritionnisteDao;
import dataAccess.NutritionnisteDaoImp;
import model.Nutritionniste;

import java.util.ArrayList;

public class NutritionnisteServiceImp implements NutritionnisteService {
    private NutritionnisteDao nutritionnisteDao;

    public NutritionnisteServiceImp() {
        setNutritionnisteDao(new NutritionnisteDaoImp());
    }

    public ArrayList<Nutritionniste> listingNutritionnistes() {
        return nutritionnisteDao.listingNutritionnistes();
    }

    public void setNutritionnisteDao(NutritionnisteDao nutritionnisteDao) {
        this.nutritionnisteDao = nutritionnisteDao;
    }
}
